package com.example.contactapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var rvContacts: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contacts()

    }

fun contacts(){
    var contactList= listOf<Contacts>(
        Contacts("Denis John","+254701474997","deojohn@gmail.com"),
        Contacts("Jane Doe","+25470178787","janedoe@gmail.com"),
        Contacts("Rita Ora","+254722676997","ora55rita@gmail.com"),
        Contacts("James Cosby","+25476656557","jamescosby@gmail.com"),
        Contacts("Peter Smith","+25470178788","petersmith@gmail.com"),
        Contacts("Anna Kendrick","+25567677877","kendrickanna@gmail.com"),
        Contacts("Lamar John","+254701474997","jonlamar21@gmail.com"),
        Contacts("Duncan Rodney","+2547567890","rodneydan@gmail.com"),
        Contacts("Elvis Presley","+25478999997","presleyelvis@gmail.com"),
        Contacts("Lewis Hamilton","+256798987777","hamiltonlewis@gmail.com"),

    )
    rvContacts=findViewById(R.id.rvContacts)
    var contactAdapter=ContactsRVAdapter(contactList)
    rvContacts.layoutManager=LinearLayoutManager(baseContext)
    rvContacts.adapter=contactAdapter
}
}