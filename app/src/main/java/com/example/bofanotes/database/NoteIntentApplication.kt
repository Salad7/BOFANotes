package com.example.bofanotes.database

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Note
import android.util.Log

class NoteIntentApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Log.d("NoteIntentApplication","Initialized Repository")
        NoteRepository.initialize(baseContext)
    }
}