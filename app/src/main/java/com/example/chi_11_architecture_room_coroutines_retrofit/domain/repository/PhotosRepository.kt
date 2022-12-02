package com.example.chi_11_architecture_room_coroutines_retrofit.domain.repository

import androidx.lifecycle.LiveData
import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.model.PhotoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow

interface PhotosRepository {

    /**
     * Method for adding a new photo from the internet.
     */
    suspend fun addPhoto()

    /**
     *  Method for getting all photos from the database.
     */
    fun fetchAllPhotos(): Flow<List<PhotoEntity>>
}