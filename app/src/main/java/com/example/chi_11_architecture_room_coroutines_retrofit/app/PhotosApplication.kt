package com.example.chi_11_architecture_room_coroutines_retrofit.app

import android.app.Application
import com.example.chi_11_architecture_room_coroutines_retrofit.data.db.PhotosDataBase
import com.example.chi_11_architecture_room_coroutines_retrofit.di.Injection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class PhotosApplication : Application() {
    companion object{
        val applicationScope = CoroutineScope(SupervisorJob())
    }

    override fun onCreate() {
        super.onCreate()
        Injection.initInjection(PhotosDataBase.getDataBase(this, applicationScope))
    }
}