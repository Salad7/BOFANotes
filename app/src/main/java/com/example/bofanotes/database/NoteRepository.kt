package com.example.bofanotes.database

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Room

class NoteRepository(context : Context) {
    private val database : NoteDatabase = Room.databaseBuilder(
        context.applicationContext,
        NoteDatabase::class.java,""
    ).build()

    suspend fun getNotes(): List<Note> = database.

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