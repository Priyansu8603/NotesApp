package com.example.notesapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.notesapp.Data.Api.NoteAPI
import com.example.notesapp.databinding.FragmentHomescreenBinding
import com.example.notesapp.utilities.TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class Homescreen: Fragment() {


    private var _binding: FragmentHomescreenBinding? = null
    private val binding get() = _binding!!


    @Inject
    lateinit var noteAPI: NoteAPI


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomescreenBinding.inflate(inflater, container, false)

        CoroutineScope(Dispatchers.IO).launch {
            val response = noteAPI.getNotes()
            Log.d(TAG,response.body().toString())
        }


        return binding.root


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
