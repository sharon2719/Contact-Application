package com.example.contactapplication.viewmodel

import android.provider.ContactsContract
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactapplication.models.Contacts
import com.example.contactapplication.repository.ContactsRepository
import kotlinx.coroutines.launch

class ContactsViewModel:ViewModel() {
   var contactsRepository=ContactsRepository()
    lateinit var contactsLiveData:LiveData<List<Contacts>>
    lateinit var  contactLiveData: LiveData<Contacts>
    fun saveContact(contact:Contacts){
        viewModelScope.launch {
            contactsRepository.saveContact(contact)
        }
    }
    fun getAllContacts(){
        contactsLiveData=contactsRepository.fetchContacts()
    }
    
    fun getContactsById(contactId:Int){
        contactLiveData=contactsRepository.getContactById(contactId)
    }

    fun deleteContact(contact: Contacts) {

    }
}