package com.example.chi_11_architecture_room_coroutines_retrofit.di

import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.PhotosDataBase
import com.example.chi_11_architecture_room_coroutines_retrofit.data.network.api.RetrofitService
import com.example.chi_11_architecture_room_coroutines_retrofit.data.repository.PhotosRepositoryImpl
import com.example.chi_11_architecture_room_coroutines_retrofit.domain.usecase.impl.GetOnePhotoUseCaseImpl
import com.example.chi_11_architecture_room_coroutines_retrofit.presentation.ViewModelFactory
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Injection {
    private lateinit var dataBase: PhotosDataBase
    private const val BASE_URL = "https://api.pexels.com/v1/"
    const val API_KEY = "563492ad6f917000010000013a82c5e17bd7414699872efae15a20a8"


    fun initInjection(dataBase: PhotosDataBase) {
        this.dataBase = dataBase
    }

    private fun provideRetrofitService(): RetrofitService {
        val okHttpClient = OkHttpClient().newBuilder().addInterceptor { chain ->
            val newRequest = chain.request().newBuilder()
                .addHeader("Authorization", API_KEY)
                .build()
            chain.proceed(newRequest)
        }

        return Retrofit.Builder()
            .client(okHttpClient.build())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(RetrofitService::class.java)
    }

    private fun providePhotosDao() = dataBase.photosDao

    fun providePhotosRepository() =
        PhotosRepositoryImpl.getInstance(provideRetrofitService(), providePhotosDao())

    fun provideGetOnePhotoUseCase() = GetOnePhotoUseCaseImpl()

    fun provideModelFactory() = ViewModelFactory.getInstance()

}