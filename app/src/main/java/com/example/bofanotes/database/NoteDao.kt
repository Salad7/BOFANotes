package com.example.bofanotes.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface NoteDao {
    @Insert
    abstract fun insertNote(noteObj: NoteObj)

    @Query("SELECT * FROM NoteObj")
    suspend fun getNotes(): List<NoteObj>
}