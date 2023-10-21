package com.example.notesapp.Repository

import androidx.lifecycle.LiveData
import com.example.notesapp.Dao.NotesDao
import com.example.notesapp.Databse.NotesDatabase
import com.example.notesapp.ui.Model.NotesEntity
import com.example.notesapp.ui.activity.notes

class NotesRepository(private val dao: NotesDao) {

    val allNotes: LiveData<List<NotesEntity>> = dao.getNotes()

    suspend fun insert(note: NotesEntity){

        dao.insertNotes(note)
    }

    suspend fun delete(note: NotesEntity){

        dao.deleteNotes(note)
    }

    suspend fun update(note: NotesEntity){

        dao.updateNotes(note.id,note.title,note.note)
    }

}
