package com.example.chi_11_architecture_room_coroutines_retrofit.data.network.model.response

import com.google.gson.annotations.SerializedName

data class SrcResponseModel(
    val original: String?,

    @SerializedName("large2x")
    val large2X: String?,

    val large: String?,
    val medium: String?,
    val small: String?,
    val portrait: String?,
    val landscape: String?,
    val tiny: String?
)
