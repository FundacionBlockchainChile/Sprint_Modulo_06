package com.example.contactapp.repository

import com.example.contactapp.model.ContactModel
import com.example.contactapp.room.ContactDao
import kotlinx.coroutines.flow.Flow

class ContactRepository(private val contactDao: ContactDao) {

    fun getAllContacts(): Flow<List<ContactModel>> = contactDao.getContacts()

    suspend fun insertContact(contact: ContactModel) {
        contactDao.insertContact(contact)
    }

    suspend fun updateContact(contact: ContactModel) {
        contactDao.updateContact(contact)
    }

    suspend fun deleteContact(contact: ContactModel) {
        contactDao.deleteContact(contact)
    }
}
