package com.example.contactapplication

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ContactsRVAdapter (var contactList: List<Contacts>,var context: Context):RecyclerView.Adapter<ContactViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        var itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_list,parent,false)   //If an item is clicked it registers for the specific item
        return ContactViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {//displaays item on screen
        var currentContact=contactList.get(position)
        holder.tvName.text=currentContact.name
        holder.tvPhone.text=currentContact.phone
        holder.tvEmail.text=currentContact.email
        Picasso.get()
            .load(currentContact.imageUrl)
            .resize(80,80)
            .centerCrop()
//            .placeholder(R.drawable.placeholder)
            .into(holder.ivContact)

        holder.cvContact.setOnClickListener {
            var intent=Intent(context,CotactDetailsActivity::class.java)
            intent.putExtra("NAME",currentContact.name)
            intent.putExtra("PHONE",currentContact.phone)
            intent.putExtra("EMAIL",currentContact.email)
            intent.putExtra("IMAGE",currentContact.imageUrl)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(intent)

        }
        holder.ivContact
//        holder.ivContact.setOnClickListener {
//            Toast.makeText(context,"You have clicked on my face",Toast.LENGTH_LONG).show()
//        }
    }
    override fun getItemCount(): Int {
        return contactList.size
    }
}
class ContactViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvName=itemView.findViewById<TextView>(R.id.tvName)
    var tvPhone=itemView.findViewById<TextView>(R.id.tvPhone)
    var tvEmail=itemView.findViewById<TextView>(R.id.tvEmail)
    var ivContact=itemView.findViewById<ImageView>(R.id.ivContact)
    var cvContact=itemView.findViewById<CardView>(R.id.cvContact)
}