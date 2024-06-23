package com.example.notesapp.Repository

import androidx.lifecycle.LiveData
import com.example.notesapp.Dao.NotesDao
import com.example.notesapp.Databse.NotesDatabase
import com.example.notesapp.ui.Model.NotesEntity
import com.example.notesapp.ui.activity.notes

class NotesRepository(private val dao: NotesDao) {

    val allNotes: LiveData<List<NotesEntity>> = dao.getNotes()

    fun insert(note: NotesEntity){

        dao.insertNotes(note)
    }

//    fun delete(id:Int){
//
//        dao.deleteNotes(id)
//    }

    fun update(note: NotesEntity){

        dao.updateNotes(note)
    }

}
