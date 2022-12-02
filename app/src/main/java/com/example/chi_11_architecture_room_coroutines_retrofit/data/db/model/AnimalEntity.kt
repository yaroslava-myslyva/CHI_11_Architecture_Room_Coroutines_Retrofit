package com.example.chi_11_architecture_room_coroutines_retrofit.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "animalEntity")
data class AnimalEntity(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val name: String,
    val latin_name: String,
    val animal_type: String,
    val active_time: String,
    val length_min: Float,
    val length_max: Float,
    val weight_min: Float,
    val weight_max: Float,
    val lifespan: Int,
    val habitat: String,
    val diet: String,
    val geo_range: String,
    val image_link: String,
    val response_id: Int
)