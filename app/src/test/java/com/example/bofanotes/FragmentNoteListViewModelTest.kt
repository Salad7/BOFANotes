package com.example.bofanotes

import android.util.Log
import kotlinx.coroutines.*
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
@ExperimentalCoroutinesApi
class FragmentNoteListViewModelTest {
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
//        Dispatchers.Main. = mainThreadSurrogate
    }
//
    @After
    fun tearDown() {
//        Dispatchers. // reset the main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }


    @Test
    fun checkNoteListSize(){
        runBlocking {
            launch(Dispatchers.Main) {  // Will be launched in the mainThreadSurrogate dispatcher
                // ...
//                Log.d("FragmentNoteListViewModelTest","Boop")
                val notelist = FragmentNoteListViewModel()
                notelist.addNote()
                assertEquals(1, notelist.notes.size)
            }
        }
    }


}