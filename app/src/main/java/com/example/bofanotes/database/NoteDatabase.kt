package com.example.bofanotes.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteObj::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao() : NoteDao
}