package com.example.chi_11_architecture_room_coroutines_retrofit.di

import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.AnimalsDataBase
import com.example.chi_11_architecture_room_coroutines_retrofit.data.network.api.RetrofitService
import com.example.chi_11_architecture_room_coroutines_retrofit.data.repository.AnimalsRepositoryImpl
import com.example.chi_11_architecture_room_coroutines_retrofit.data.repository.AnimalsRepositoryImpl.*
import com.example.chi_11_architecture_room_coroutines_retrofit.domain.repository.AnimalsRepository
import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Injection {
    private lateinit var dataBase: AnimalsDataBase
    private const val BASE_URL = "https://zoo-animal-api.herokuapp.com/"

    fun initInjection(dataBase: AnimalsDataBase) {
        this.dataBase = dataBase
    }

    private fun provideRetrofitService(): RetrofitService {
        val okHttpClient = OkHttpClient().newBuilder()

        return Retrofit.Builder()
            .client(okHttpClient.build())
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(RetrofitService::class.java)
    }

    private fun provideAnimalsDao() = dataBase.animalsDao

    fun provideAnimalsRepository() =
        AnimalsRepositoryImpl.getInstance(provideRetrofitService(), provideAnimalsDao())


}