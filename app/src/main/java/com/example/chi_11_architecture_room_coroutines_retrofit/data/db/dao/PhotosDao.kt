package com.example.chi_11_architecture_room_coroutines_retrofit.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.model.PhotoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotosDao {

    /**
     * Method for adding one animal
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPhoto(animal :PhotoEntity)

    /**
     * Method for getting all animals
     */
    @Query("SELECT * FROM photoEntity")
    fun fetchPhotos(): Flow<List<PhotoEntity>>
}