package com.example.chi_11_architecture_room_coroutines_retrofit.data.repository

import android.util.Log
import com.example.chi_11_architecture_room_coroutines_retrofit.MainActivity.Companion.TAG
import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.dao.PhotosDao
import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.model.PhotoEntity
import com.example.chi_11_architecture_room_coroutines_retrofit.data.network.api.RetrofitService
import com.example.chi_11_architecture_room_coroutines_retrofit.data.network.model.response.WholeResponseModel
import com.example.chi_11_architecture_room_coroutines_retrofit.domain.repository.PhotosRepository
import kotlinx.coroutines.flow.Flow

class PhotosRepositoryImpl(
    private val retrofitService: RetrofitService,
    private val dao: PhotosDao
) : PhotosRepository {

    companion object {
        private var instance: PhotosRepositoryImpl? = null
        fun getInstance(
            retrofitService: RetrofitService,
            dao: PhotosDao
        ): PhotosRepositoryImpl {
            if (instance == null) {
                instance = PhotosRepositoryImpl(retrofitService, dao)
            }
            return instance as PhotosRepositoryImpl
        }
    }

    override suspend fun addPhoto() {
        kotlin.runCatching {
            val photoResponse =
                retrofitService.getResponseItem(
                    listOf(('0'..'9'), ('a'..'z'), ('A'..'Z')).flatten().random().toString(), 1
                ).execute()
            val wholeResponseModelBody = photoResponse.body() as WholeResponseModel

            wholeResponseModelBody.photos?.forEach { photoResponseModel ->
                photoResponseModel.mapToPhotoEntity().let { photoEntity ->
                    dao.addPhoto(photoEntity)
                }

            }
        }.onFailure {
            Log.d(TAG, "error - ${it.message}")
        }
    }

    override fun fetchAllPhotos(): Flow<List<PhotoEntity>> = dao.fetchPhotos()
}