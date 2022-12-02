package com.example.chi_11_architecture_room_coroutines_retrofit.data.network.model.response

import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.model.AnimalEntity

data class AnimalResponseModel(
    val name: String?,
    val latin_name: String?,
    val animal_type: String?,
    val active_time: String?,
    val length_min: Float?,
    val length_max: Float?,
    val weight_min: Float?,
    val weight_max: Float?,
    val lifespan: Int?,
    val habitat: String?,
    val diet: String?,
    val geo_range: String?,
    val image_link: String?,
    val id: Int?
) {
    fun mapToAnimalEntity(): AnimalEntity = AnimalEntity(
        name = name ?: "",
        latin_name = latin_name ?: "",
        animal_type = animal_type ?: "",
        active_time = active_time ?: "",
        length_min = length_min ?: 0.0f,
        length_max = length_max ?: 0.0f,
        weight_min = weight_min ?: 0.0f,
        weight_max = weight_max ?: 0.0f,
        lifespan = lifespan ?: 0,
        habitat = habitat ?: "",
        diet = diet ?: "",
        geo_range = geo_range ?: "",
        image_link = image_link ?: "",
        response_id = id ?: 0
    )
}