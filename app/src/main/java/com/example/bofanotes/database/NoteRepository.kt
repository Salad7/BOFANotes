package com.example.bofanotes.database

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Note
import android.util.Log
import androidx.room.Room
import kotlinx.coroutines.flow.Flow

class NoteRepository(context : Context) {
    private val database : NoteDatabase = Room.databaseBuilder(
        context.applicationContext,
        NoteDatabase::class.java,"note-database"
    ).build()

    fun getNotes(): Flow<List<NoteObj>> = database.noteDao().getNotes()
    fun insertNote(note :NoteObj){
        Log.d("NoteRepository","Inserting note")
        database.noteDao().insertNote(note)
    }
    fun deleteNote(note: NoteObj){
        Log.d("NoteRepository","Deleting note")
        database.noteDao().deleteNote(note)

    }
    companion object {
        var INSTANCE : NoteRepository? = null

         fun initialize(context: Context){
                if(INSTANCE == null){
                    INSTANCE = NoteRepository(context)
                }
        }
         fun get() : NoteRepository{
            return INSTANCE ?: throw IllegalStateException("Note Repository must be initialized")
        }
    }
}