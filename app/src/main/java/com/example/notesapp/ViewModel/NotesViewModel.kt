package com.example.notesapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.Dao.NotesDao
import com.example.notesapp.Databse.DatabaseBuilder
import com.example.notesapp.Databse.NotesDatabase
import com.example.notesapp.Repository.NotesRepository
import com.example.notesapp.ui.Model.NotesEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class NotesViewModel(application: Application): AndroidViewModel(application) {

    private val repository:NotesRepository

    val allnotes : LiveData<List<NotesEntity>>


    init{
        val dao = DatabaseBuilder.getDatabase(application ).myNotesDao()
        repository = NotesRepository(dao)
        allnotes = repository.allNotes
    }
//
//    fun deleteNote(id:Int) = viewModelScope.launch(Dispatchers.IO){
//
//        repository.delete(id)
//    }

    fun getNotes() = viewModelScope.launch(Dispatchers.IO){

        repository.allNotes
    }

    fun insertNote(note:NotesEntity) = viewModelScope.launch(Dispatchers.IO){

        repository.insert(note)
    }

    fun updateNote(note:NotesEntity) = viewModelScope.launch(Dispatchers.IO){

        repository.update(note)
    }






}