package com.example.notesapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.ui.Model.NotesEntity

class NotesAdapter(private val context: Context) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    private val NotesList :ArrayList<NotesEntity>()
    private val FullList :ArrayList<NotesEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_notes,parent,false)
        )
    }

    override fun getItemCount(): Int {
        return NotesList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote =NotesList  [position]
        holder.title.setText = currentNote.title
        holder.title.isSelected = true

        holder.Note_Tv.text = currentNote.note
        holder.date.text = currentNote.date
        holder.date.isSelected = true
    }



    inner class NoteViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val notes_layout = itemView.findViewById<CardView>(R.id.item_layout)
        val title = itemView.findViewById<CardView>(R.id.tv_title)
        val Note_Tv =  itemView.findViewById<CardView>(R.id.tv_note)
        val date = itemView.findViewById<CardView>(R.id.tv_date)

    }

}