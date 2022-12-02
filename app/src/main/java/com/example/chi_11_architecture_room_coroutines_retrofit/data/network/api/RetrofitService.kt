package com.example.chi_11_architecture_room_coroutines_retrofit.data.network.api

import com.example.chi_11_architecture_room_coroutines_retrofit.data.network.model.response.WholeResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    /**
     * Method for getting a new random photo
     */
    @GET("search")
    fun getResponseItem(
        @Query("query") query: String?,
        @Query("per_page") itemNum: Int
    ): Call<WholeResponseModel>
}
