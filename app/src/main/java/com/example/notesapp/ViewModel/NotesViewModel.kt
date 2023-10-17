package com.example.notesapp.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.notesapp.Dao.NotesDao
import com.example.notesapp.Databse.NotesDatabase
import com.example.notesapp.Repository.NotesRepository
import com.example.notesapp.ui.Model.NotesEntity

class NotesViewModel(application: Application):AndroidViewModel(application) {
    private val repository:NotesRepository

    init {
        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository = NotesRepository(dao)
    }

    fun getNotes():LiveData<List<NotesEntity>> = repository.getAllNotes()

    fun addNotes(notes:NotesEntity){
        repository.insertAllNotes(notes)
    }

    fun updateNotes(notes: NotesEntity){
        repository.updateAllNotes(notes)
    }

    fun deleteNotes(id:Int){
        repository.deleteAllNotes(id)
    }





}