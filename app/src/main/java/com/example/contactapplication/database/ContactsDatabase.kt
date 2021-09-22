package com.example.contactapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.contactapplication.models.Contacts


@Database(entities = arrayOf(Contacts::class), version = 1)
 abstract class ContactsDatabase:RoomDatabase() {
    abstract  fun getContactsDao():ContactsDao

    abstract fun getNotesDao(): NotesDao
    companion object {
        private var database: ContactsDatabase? = null

        fun getDatabase(context: Context): ContactsDatabase{
            if(database==null){
                database=Room.databaseBuilder(context,ContactsDatabase::class.java,"ContactsDb")
                    .fallbackToDestructiveMigration().build()
            }
            return  database as ContactsDatabase
        }
    }

}