package com.example.chi_11_architecture_room_coroutines_retrofit.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chi_11_architecture_room_coroutines_retrofit.R

class AnimalFragment : Fragment() {

    companion object {
        fun newInstance() = AnimalFragment()
    }

    private lateinit var viewModel: AnimalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_animal, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnimalViewModel::class.java)
        // TODO: Use the ViewModel
    }

}