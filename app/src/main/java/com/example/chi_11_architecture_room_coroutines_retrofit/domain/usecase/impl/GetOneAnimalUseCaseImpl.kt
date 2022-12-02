package com.example.chi_11_architecture_room_coroutines_retrofit.domain.usecase.impl

import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.model.AnimalEntity
import com.example.chi_11_architecture_room_coroutines_retrofit.di.Injection
import com.example.chi_11_architecture_room_coroutines_retrofit.domain.usecase.api.GetOneAnimalUseCase
import kotlinx.coroutines.flow.Flow

class GetOneAnimalUseCaseImpl : GetOneAnimalUseCase {
    private val repository = Injection.provideAnimalsRepository()
    override suspend fun execute(): Flow<List<AnimalEntity>> {
        repository.addAnimal()
        return repository.fetchAllAnimals()
    }
}