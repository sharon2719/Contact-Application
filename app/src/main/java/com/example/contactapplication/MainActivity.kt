package com.example.contactapplication

import android.content.Context
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
        Contacts("Denis John","+254701474997","deojohn@gmail.com","https://images.pexels.com/photos/5871217/pexels-photo-5871217.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
        Contacts("Jane Doe","+25470178787","janedoe@gmail.com","https://images.pexels.com/photos/6542749/pexels-photo-6542749.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
        Contacts("Rita Ora","+254722676997","ora55rita@gmail.com","https://images.pexels.com/photos/5987169/pexels-photo-5987169.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
        Contacts("James Cosby","+25476656557","jamescosby@gmail.com","https://images.pexels.com/photos/7214824/pexels-photo-7214824.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
        Contacts("Peter Smith","+25470178788","petersmith@gmail.com","https://images.pexels.com/photos/2568410/pexels-photo-2568410.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
        Contacts("Anna Kendrick","+25567677877","kendrickanna@gmail.com","https://images.pexels.com/photos/4937366/pexels-photo-4937366.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
        Contacts("Lamar John","+254701474997","jonlamar21@gmail.com","https://images.pexels.com/photos/762545/pexels-photo-762545.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
        Contacts("Duncan Rodney","+2547567890","rodneydan@gmail.com","https://images.pexels.com/photos/2083496/pexels-photo-2083496.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
        Contacts("Elvis Presley","+25478999997","presleyelvis@gmail.com","https://images.pexels.com/photos/3193739/pexels-photo-3193739.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
        Contacts("Lewis Hamilton","+256798987777","hamiltonlewis@gmail.com","https://images.pexels.com/photos/4727494/pexels-photo-4727494.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"),
    )
    rvContacts=findViewById(R.id.rvContacts)
    var contactAdapter=ContactsRVAdapter(contactList,baseContext)
    rvContacts.layoutManager=LinearLayoutManager(baseContext)
    rvContacts.adapter=contactAdapter
}
}