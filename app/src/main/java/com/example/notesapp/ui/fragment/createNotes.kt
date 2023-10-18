package com.example.notesapp.ui.fragment

import android.os.Bundle
import android.text.format.DateFormat
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notesapp.R
import com.example.notesapp.ViewModel.NotesViewModel
import com.example.notesapp.databinding.FragmentCreateNotesBinding
import com.example.notesapp.ui.Model.NotesEntity
import java.util.Date


class createNotes : Fragment() {

    private lateinit var binding: FragmentCreateNotesBinding
    private lateinit var myViewModel :NotesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreateNotesBinding.inflate(layoutInflater,container,false)

        myViewModel=ViewModelProvider(this).get(NotesViewModel::class.java)

        binding.saveNotes.setOnClickListener{
            createTheNotes(it)
        }



        return binding.root
    }

    fun createTheNotes(it: View?) {


        val title = binding.editTxtTitle.text.toString()
        val subtitle = binding.editTxtSubTitle.text.toString()
        val descriptiveNotes = binding.editTxtDescriptiveNotes.text.toString()

        val d = Date()
        val date: CharSequence = DateFormat.format("MMMM d, yyyy ",d.time)

        val data= NotesEntity(null,title=title, subtitle = subtitle, date=date.toString(), notes=descriptiveNotes)
        myViewModel.addNotes(data)

        Toast.makeText(context,"Notes Created Success 😊👍✅ !!",Toast.LENGTH_SHORT).show()

    }

}