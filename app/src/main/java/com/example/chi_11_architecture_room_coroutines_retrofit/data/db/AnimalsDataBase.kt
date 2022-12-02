package com.example.chi_11_architecture_room_coroutines_retrofit.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.dao.AnimalsDao
import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.model.AnimalEntity
import kotlinx.coroutines.CoroutineScope
import java.util.*

@Database(
    version = 1,
    entities = [
        AnimalEntity::class
    ]
)
abstract class AnimalsDataBase : RoomDatabase() {

    abstract val animalsDao: AnimalsDao

    companion object {
        private const val DB_NAME = "animalDataBase"

        @Volatile
        private var instance: AnimalsDataBase? = null

        fun getDataBase(
            context: Context,
            scope: CoroutineScope
        ): AnimalsDataBase {
            return instance ?: synchronized(this) {

                val newDb = Room.databaseBuilder(
                    context.applicationContext,
                    AnimalsDataBase::class.java,
                    DB_NAME
                )
                    .build()
                instance = newDb
                newDb
            }
        }
    }

}