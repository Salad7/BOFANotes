package com.example.bofanotes

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.util.*

class FragmentNoteListViewModel : ViewModel() {
    var notes = mutableListOf<Note>()

//    lateinit var notesFlow : Flow<MutableList<Note>>
    init{
        //Create a new user, add to the notes list
        viewModelScope.launch {
            Log.d("FragmentnoteListViewModel","Added note!")
//            getNotes()
        }
    }

    suspend fun getNotes() : List<Note> {
        return notes
    }
    suspend fun addNote() : Int{
        notes.add(Note(UUID.randomUUID(),1000,"Test Message"))
        return notes.size
    }
}