package com.example.contactapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactapplication.ContactsRVAdapter
import com.example.contactapplication.databinding.ActivityMainBinding
import com.example.contactapplication.models.Contacts
import com.example.contactapplication.viewmodel.ContactsViewModel

class MainActivity : AppCompatActivity() {

    val contactsViewModel:ContactsViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        contactsViewModel.getAllContacts()
    }

    override fun onResume() {
        super.onResume()
        contactsViewModel.contactsLiveData.observe(this,{contacts->
            displayContacts(contacts)

        })
        binding.fabAddContact.setOnClickListener {
            startActivity(Intent(this,AddContactActivity::class.java))
        }
    }

fun displayContacts(contactList: List<Contacts>){

    var contactAdapter= ContactsRVAdapter(contactList ,baseContext,object :ContactClickListener{
        override fun onClickDeleteContact(contact:Contacts){
        contactsViewModel.deleteContact(contact)
    }})
    binding.rvContacts.layoutManager=LinearLayoutManager(baseContext)
    binding.rvContacts.adapter=contactAdapter
}
    interface ContactClickListener{
       fun onClickDeleteContact(contact:Contacts)


    }
}