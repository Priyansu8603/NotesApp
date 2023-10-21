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

    @Query("SELECT * FROM Notes_Table order by id ASC")
    fun getNotes(): LiveData<List<NotesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(note: NotesEntity)

    @Delete
    suspend fun deleteNotes(note: NotesEntity)

    @Query("UPDATE Notes_Table Set title = :title, note = :note WHERE id =:id ")
    suspend fun updateNotes(id:Int?, title:String?, note:String?)

}