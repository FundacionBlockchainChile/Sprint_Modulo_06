package com.example.contactapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.contactapp.room.ImagesDao
import com.example.contactapp.model.ImagesModel

@Database(entities = [ImagesModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun imageDao(): ImagesDao
}