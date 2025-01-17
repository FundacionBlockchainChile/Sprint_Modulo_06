package com.example.contactapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.contactapp.model.ImagesModel
import com.example.contactapp.room.AppDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.File

class ImagesViewModel(application: Application): AndroidViewModel(application) {

    private val db = Room.databaseBuilder(
        application,
        AppDatabase::class.java,
        "images_database"
    ).build()

    private val _imagesList = MutableStateFlow<List<ImagesModel>>(emptyList())
    val imageList = _imagesList.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            db.imageDao().getImages().collect { item ->
                _imagesList.value = item
            }
        }
    }

    fun insertImage(item: ImagesModel) {
        viewModelScope.launch(Dispatchers.IO) {
            db.imageDao().insertImage(item)
        }
    }

    fun deleteImage(item: ImagesModel) {
        viewModelScope.launch(Dispatchers.IO) {
            deletePhoto(item.ruta)
            db.imageDao().deleteImage(item)
        }
    }

    private fun deletePhoto(photoPath: String) {
        val file = File(photoPath)
        if (file.exists()) {
            file.delete()
        }
    }



}
