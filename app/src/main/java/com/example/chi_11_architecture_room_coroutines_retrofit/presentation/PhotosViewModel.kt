package com.example.chi_11_architecture_room_coroutines_retrofit.presentation

import androidx.lifecycle.ViewModel
import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.model.PhotoEntity
import com.example.chi_11_architecture_room_coroutines_retrofit.di.Injection
import kotlinx.coroutines.flow.Flow

class PhotosViewModel : ViewModel() {
    fun getNewPhoto(): Flow<List<PhotoEntity>> = Injection.provideGetOnePhotoUseCase().execute()
}
