package com.example.contactapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contactapp.model.ContactModel

@Database(entities = [ContactModel::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun contactDao(): ContactDao
}