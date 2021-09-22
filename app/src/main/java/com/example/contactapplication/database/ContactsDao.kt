package com.example.contactapplication.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.contactapplication.models.Contacts

@Dao
interface ContactsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertContacts(contact:Contacts)

    @Query("SELECT * FROM Contacts")
    fun getAllContacts():LiveData<List<Contacts>>

    @Query("SELECT * FROM Contacts WHERE contactId = :contactId")
    fun getContactById(contactId:Int):LiveData<Contacts>

    @Delete
    fun deleteContact(contact: Contacts)
}

