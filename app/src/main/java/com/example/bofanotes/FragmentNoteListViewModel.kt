package com.example.bofanotes

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bofanotes.database.NoteObj
import com.example.bofanotes.database.NoteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*

class FragmentNoteListViewModel : ViewModel() {
    var repo = NoteRepository.get()
     var notes = repo.getNotes()

//    lateinit var notesFlow : Flow<MutableList<Note>>
    init{
        //Create a new user, add to the notes list
        viewModelScope.launch {
//            Log.d("FragmentnoteListViewModel","Added note!")
//            getNotes()

        }
    }

//    suspend fun getNotes() : List<Note> {
//        return notes
//    }
//    suspend fun addNote() : Int{
//        notes.add(Note(UUID.randomUUID(),1000,"Test Message"))
//        repo.insertNote()
//        return notes.size
//    }

     fun insertNode(n :NoteObj) {

         viewModelScope.launch {
             withContext(Dispatchers.IO){
                 repo.insertNote(n)
                 Log.d("FragmentNoteListViewModel", "Added custom note")
             }

//        return notes.size }
         }
     }
    fun deleteNote(n :NoteObj) {

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                repo.deleteNote(n)
                Log.d("FragmentNoteListViewModel", "Deleted custom note")
            }

//        return notes.size }
        }
    }
}