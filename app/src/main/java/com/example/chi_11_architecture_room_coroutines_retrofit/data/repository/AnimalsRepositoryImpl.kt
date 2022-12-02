package com.example.chi_11_architecture_room_coroutines_retrofit.data.repository

import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.dao.AnimalsDao
import com.example.chi_11_architecture_room_coroutines_retrofit.data.network.api.RetrofitService
import com.example.chi_11_architecture_room_coroutines_retrofit.data.network.model.response.AnimalResponseModel
import com.example.chi_11_architecture_room_coroutines_retrofit.domain.repository.AnimalsRepository

class AnimalsRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val dao: AnimalsDao
) : AnimalsRepository {

    companion object{
        private var instance: AnimalsRepositoryImpl? = null
        fun getInstance(
            retrofitService: RetrofitService,
            dao: AnimalsDao
        ): AnimalsRepositoryImpl {
            if (instance == null) {
                instance = AnimalsRepositoryImpl(retrofitService, dao)
            }
            return instance as AnimalsRepositoryImpl
        }
    }

    override suspend fun addAnimal() {
        val animalResponse =
            retrofitService.getResponseItem().execute().body() as AnimalResponseModel
        dao.addAnimal(animalResponse.mapToAnimalEntity())
    }

    override suspend fun fetchAllAnimals() = dao.fetchAnimals()
}