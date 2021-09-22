package com.example.contactapplication.repository

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import com.example.contactapplication.ContactsApp
import com.example.contactapplication.database.ContactsDatabase
import com.example.contacts.model.Note
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.sql.RowId

class NotesRepository {
    val db=ContactsDatabase.getDatabase(ContactsApp.appContext)

    suspend fun saveNote(note:Note){
        withContext(Dispatchers.IO){
            db.getNotesDao().insertNote(note)
        }

    }
    fun getAllNotes():LiveData<List<Note>>{
        return db.getNotesDao().getAllNotes()
    }
    fun getNoteById(noteId:Int):LiveData<Note>{
        return db.getNotesDao().getNoteById(noteId)
    }

}