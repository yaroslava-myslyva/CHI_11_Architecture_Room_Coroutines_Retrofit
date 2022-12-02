package com.example.chi_11_architecture_room_coroutines_retrofit.data.network.api

import com.example.chi_11_architecture_room_coroutines_retrofit.data.network.model.response.AnimalResponseModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET("/animals/rand/1/")
    fun getResponseItem(): Call<AnimalResponseModel>

}