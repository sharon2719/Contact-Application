package com.example.contactapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.contactapplication.databinding.ActivityAddContactBinding
import com.example.contactapplication.models.Contacts
import com.example.contactapplication.viewmodel.ContactsViewModel

class AddContactActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddContactBinding
    val contactsViewModel: ContactsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAddContactBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btnSave.setOnClickListener {
            validateContact()


        }
    }
    fun validateContact(){
        var name=binding.etName.text.toString()
        var email=binding.etEmail.text.toString()
        var phoneNumber=binding.etPhone.text.toString()
        var error=false

        if (name.isEmpty()&& name.isBlank()){
            error=true
            binding.tilName.error="Name is required"
        }
        if (phoneNumber.isEmpty()&& phoneNumber.isBlank()){
            error=true
            binding.tilPhone.error="Phone number is required"
        }
        if (email.isEmpty()&& email.isBlank()){
            error=true
            binding.tilEmail.error="Email is required"
        }
        if (!error){
        var contact=Contacts(0,name,phoneNumber,email,"")
        contactsViewModel.saveContact(contact)
            binding.etName.setText("")
            binding.etEmail.setText("")
            binding.etPhone.setText("")
        }


    }}
