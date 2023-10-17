package com.example.notesapp.Repository

import androidx.lifecycle.LiveData
import com.example.notesapp.Dao.NotesDao
import com.example.notesapp.ui.Model.NotesEntity
import com.example.notesapp.ui.activity.notes

class NotesRepository(val dao: NotesDao) {

    fun getAllNotes():LiveData<List<NotesEntity>>{
        return dao.getNotes()
    }

    fun insertAllNotes(notes: NotesEntity){
        return dao.insertNotes(notes)
    }

    fun deleteAllNotes(id:Int){
      return dao.deleteNotes(id)
    }

    fun updateAllNotes(notes:NotesEntity){
        return dao.updateNotes(notes)
    }
}