package com.example.contactapp.room

import androidx.room.*
import com.example.contactapp.model.ContactModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ContactDao {

    @Query("SELECT * FROM contacts")
    fun getContacts(): Flow<List<ContactModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(contact: ContactModel)

    @Delete
    suspend fun deleteContact(contact: ContactModel)

    @Update
    suspend fun updateContact(contact: ContactModel)
}
