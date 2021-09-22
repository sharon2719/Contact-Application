package com.example.contactapplication.models

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Contacts")
data class Contacts(
    @PrimaryKey(autoGenerate = true) @NonNull var contactId: Int,
    var name: String,
    var phone: String,
    var email: String,
    var imageUrl: String
)
