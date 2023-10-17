package com.example.notesapp.ui.Model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Notes")
data class NotesEntity (
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    var title:String,
    var subtitle:String,
    var priority:String
)