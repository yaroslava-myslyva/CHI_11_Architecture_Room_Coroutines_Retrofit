package com.example.chi_11_architecture_room_coroutines_retrofit.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.model.AnimalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimalsDao {
    /**
     * Method for adding one animal
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAnimal(animal :AnimalEntity)

    /**
     * Method for getting all animals
     */
    @Query("SELECT * FROM animalEntity")
    suspend fun fetchAnimals(): Flow<List<AnimalEntity>>
}