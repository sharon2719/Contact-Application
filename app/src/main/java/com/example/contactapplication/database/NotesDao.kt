package com.example.contactapplication.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.contacts.model.Note

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNote(note: Note)

    @Query(value = "SELECT * FROM Notes")
    fun getAllNotes():LiveData<List<Note>>

    @Query("SELECT * FROM Notes WHERE noteId= :id")
    fun getNoteById(id:Int):LiveData<Note>

    @Delete
    fun deleteNote(note: Note)
}