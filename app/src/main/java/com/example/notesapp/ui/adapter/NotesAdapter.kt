package com.example.notesapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.notesapp.R
import com.example.notesapp.databinding.ItemNotesBinding
import com.example.notesapp.ui.Model.NotesEntity
import kotlin.random.Random

class NotesAdapter(private val context: Context, private val notesList:List<NotesEntity>) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNotesBinding.inflate(LayoutInflater.from(context),parent,false)

        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val data =notesList[position]

        holder.binding.tvTitle.text = data.title
        holder.binding.tvTitle.isSelected = true

        holder.binding.tvNote.text = data.note
        holder.binding.tvDate.text = data.date
        holder.binding.tvDate.isSelected = true

        holder.binding.itemLayout.setBackgroundColor(holder.itemView.resources.getColor(randomColor(),null))


    }



    fun randomColor() : Int{

        val list = ArrayList<Int>()
        list.add(R.color.NotesColor1)
        list.add(R.color.NotesColor2)
        list.add(R.color.NotesColor3)
        list.add(R.color.NotesColor4)
        list.add(R.color.NotesColor5)
        list.add(R.color.NotesColor6)

        val seed = System.currentTimeMillis().toInt()
        val randomIndex = Random(seed).nextInt(list.size)
        return list[randomIndex]

    }

    inner class NoteViewHolder(var binding: ItemNotesBinding) : RecyclerView.ViewHolder(binding.root){

    }

}