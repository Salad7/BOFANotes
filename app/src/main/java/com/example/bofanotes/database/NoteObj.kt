package com.example.bofanotes.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
data class NoteObj(@PrimaryKey val uid :UUID, val timestamp :Long, val message :String) {
}