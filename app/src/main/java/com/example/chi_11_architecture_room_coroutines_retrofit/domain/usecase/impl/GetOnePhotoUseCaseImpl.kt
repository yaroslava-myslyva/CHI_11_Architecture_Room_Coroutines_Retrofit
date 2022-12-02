package com.example.chi_11_architecture_room_coroutines_retrofit.domain.usecase.impl

import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.model.PhotoEntity
import com.example.chi_11_architecture_room_coroutines_retrofit.di.Injection
import com.example.chi_11_architecture_room_coroutines_retrofit.domain.usecase.api.GetOnePhotoUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class GetOnePhotoUseCaseImpl : GetOnePhotoUseCase {
    private val repository = Injection.providePhotosRepository()
    override fun execute(): Flow<List<PhotoEntity>> {

        MainScope().launch(Dispatchers.IO) {
            repository.addPhoto()

        }
        return repository.fetchAllPhotos()
    }
}