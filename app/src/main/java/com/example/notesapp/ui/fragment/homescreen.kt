package com.example.notesapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.notesapp.R
import com.example.notesapp.databinding.FragmentHomescreenBinding


class homescreen : Fragment() {

    lateinit var binding: FragmentHomescreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomescreenBinding.inflate(layoutInflater,container,false)

        binding.addBtn.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_homescreen_to_createNotes)
        }

        return binding.root
    }

}