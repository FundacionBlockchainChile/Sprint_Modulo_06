package com.example.contactapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.contactapp.model.ContactModel
import com.example.contactapp.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ContactViewModel(application: Application): AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "contact_database"
    ).build()

    private val _contactList = MutableStateFlow<List<ContactModel>>(emptyList())
    val contactList = _contactList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            db.contactDao().getContacts().collect { contacts ->
                _contactList.value = contacts
            }
        }
    }

    fun insertContact(contact: ContactModel) {
        viewModelScope.launch(Dispatchers.IO) {
            db.contactDao().insertContact(contact)
        }
    }

    fun updateContact(contact: ContactModel) {
        viewModelScope.launch(Dispatchers.IO) {
            db.contactDao().updateContact(contact)
        }
    }

    fun deleteContact(contact: ContactModel) {
        viewModelScope.launch(Dispatchers.IO) {
            db.contactDao().deleteContact(contact)
        }
    }
}
