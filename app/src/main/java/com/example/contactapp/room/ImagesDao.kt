package com.example.contactapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.contactapp.model.ImagesModel
import kotlinx.coroutines.flow.Flow

@Dao
interface ImagesDao {

    @Query("SELECT * FROM Images")
    fun getImages(): Flow<List<ImagesModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImage(item: ImagesModel)

    @Delete
    suspend fun deleteImage(item: ImagesModel)

}