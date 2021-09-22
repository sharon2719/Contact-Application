package com.example.contactapplication.repository

import androidx.lifecycle.LiveData
import com.example.contactapplication.ContactsApp
import com.example.contactapplication.database.ContactsDatabase
import com.example.contactapplication.models.Contacts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ContactsRepository {
    var database =ContactsDatabase.getDatabase(ContactsApp.appContext)

    suspend fun saveContact(contact:Contacts){
        withContext(Dispatchers.IO){
            database.getContactsDao().insertContacts(contact)
        }
    }

    fun getAllContacts():LiveData<List<Contacts>>{
        return database.getContactsDao().getAllContacts()
    }

    fun getContactById(contactId:Int):LiveData<Contacts>{
        return database.getContactsDao().getContactById(contactId)
    }

    fun fetchContacts(): LiveData<List<Contacts>> {
        return database.getContactsDao().getAllContacts()
    }
}