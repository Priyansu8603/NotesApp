package com.example.notesapp.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.notesapp.ui.Model.NotesEntity

@Dao
interface NotesDao {

    @Query("SELECT * FROM Notes_Table")
    fun getNotes(): LiveData<List<NotesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: NotesEntity)

//    @Delete
//    fun deleteNotes(id: Int)

    @Update
    fun updateNotes(notes: NotesEntity)

}