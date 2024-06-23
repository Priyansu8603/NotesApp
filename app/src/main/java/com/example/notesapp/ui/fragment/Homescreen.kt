package com.example.notesapp.ui.fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notesapp.ViewModel.NotesViewModel
import com.example.notesapp.databinding.FragmentHomescreenBinding
import com.example.notesapp.ui.Model.NotesEntity
import com.example.notesapp.ui.adapter.NotesAdapter


class Homescreen: Fragment() {


    private var _binding: FragmentHomescreenBinding? = null
    private val binding get() = _binding!!





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomescreenBinding.inflate(inflater, container, false)

        return binding.root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
