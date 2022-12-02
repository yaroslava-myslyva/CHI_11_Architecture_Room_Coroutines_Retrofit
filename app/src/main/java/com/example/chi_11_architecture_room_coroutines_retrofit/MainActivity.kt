package com.example.chi_11_architecture_room_coroutines_retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chi_11_architecture_room_coroutines_retrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}