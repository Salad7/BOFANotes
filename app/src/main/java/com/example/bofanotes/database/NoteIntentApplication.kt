package com.example.bofanotes.database

import android.app.Application
import android.provider.ContactsContract.CommonDataKinds.Note

class NoteIntentApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        NoteRepository.initialize(baseContext)
    }
}