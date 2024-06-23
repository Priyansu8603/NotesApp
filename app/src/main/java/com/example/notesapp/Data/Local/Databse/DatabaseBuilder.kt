package com.example.notesapp.Databse

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi

object DatabaseBuilder {

    private var INSTANCE:NotesDatabase?=null

    @OptIn(InternalCoroutinesApi::class)
    fun getDatabase(context: Context): NotesDatabase{

        if(INSTANCE==null){

            synchronized(NotesDatabase::class){
                INSTANCE = Room.databaseBuilder(
                    context,NotesDatabase::class.java,"note_database"
                ).allowMainThreadQueries().build()
            }

        }
        return INSTANCE!!
    }

}