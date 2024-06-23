package com.example.notesapp.ui.Model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Notes_Table")
data class NotesEntity (
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "title") val title:String?,
    @ColumnInfo(name = "note") val note:String?,
    @ColumnInfo(name = "date") val date:String?,
)