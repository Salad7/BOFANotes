package com.example.bofanotes.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
     fun insertNote(noteObj: NoteObj)

    @Query("SELECT * FROM noteobj")
      fun getNotes(): Flow<List<NoteObj>>

    @Delete
    fun deleteNote(noteObj :NoteObj);
}