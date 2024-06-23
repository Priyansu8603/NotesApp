package com.example.notesapp.Databse

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapp.Dao.NotesDao
import com.example.notesapp.ViewModel.NotesViewModel
import com.example.notesapp.ui.Model.NotesEntity
import com.example.notesapp.utilities.DATABASE_NAME
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized

@Database(entities = [NotesEntity::class], version = 1, exportSchema = false)
abstract class NotesDatabase : RoomDatabase(){
    abstract fun myNotesDao():NotesDao

}