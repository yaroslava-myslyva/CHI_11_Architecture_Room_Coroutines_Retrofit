package com.example.chi_11_architecture_room_coroutines_retrofit.domain.repository

import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.dao.AnimalsDao
import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.model.AnimalEntity
import com.example.chi_11_architecture_room_coroutines_retrofit.data.network.api.RetrofitService
import com.example.chi_11_architecture_room_coroutines_retrofit.data.repository.AnimalsRepositoryImpl
import kotlinx.coroutines.flow.Flow

interface AnimalsRepository {
    suspend fun addAnimal()
    suspend fun fetchAllAnimals(): Flow<List<AnimalEntity>>
}