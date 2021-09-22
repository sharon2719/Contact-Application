package com.example.contactapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.contactapplication.R
import com.squareup.picasso.Picasso

class CotactDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cotact_details)


      var intent=intent
        var image=intent.getStringExtra("IMAGE").toString()
        var name=intent.getStringExtra("NAME")
        var phone=intent.getStringExtra("PHONE")
        var email=intent.getStringExtra("EMAIL")
//        Toast.makeText(baseContext,name,Toast.LENGTH_LONG).show()
        var tvname1=findViewById<TextView>(R.id.tvName1)
        var tvEmail1=findViewById<TextView>(R.id.tvEmail1)
        var tvPhone1=findViewById<TextView>(R.id.tvPhone1)
        var ivContact1=findViewById<ImageView>(R.id.ivContact1)

        tvname1.text=name
        tvPhone1.text=phone
        tvEmail1.text=email
        Picasso.get()
            .load(image)
            .into(ivContact1)




    }
}