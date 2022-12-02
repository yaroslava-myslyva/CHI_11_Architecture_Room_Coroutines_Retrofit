package com.example.chi_11_architecture_room_coroutines_retrofit.domain.usecase.api

import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.model.AnimalEntity
import kotlinx.coroutines.flow.Flow

interface GetOneAnimalUseCase {
    suspend fun execute(): Flow<List<AnimalEntity>>
}