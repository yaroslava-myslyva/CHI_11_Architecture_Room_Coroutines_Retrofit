package com.example.chi_11_architecture_room_coroutines_retrofit.domain.usecase.api

import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.model.PhotoEntity
import kotlinx.coroutines.flow.Flow

interface GetOnePhotoUseCase {
    /**
     * Method for adding new photo in the list.
     */
    fun execute(): Flow<List<PhotoEntity>>
}