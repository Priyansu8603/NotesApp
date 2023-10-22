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

class NotesAdapter(private val context: Context, val listener: NotesClickListener) : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    private val NotesList = ArrayList<NotesEntity>()
    private val FullList  =ArrayList<NotesEntity>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNotesBinding.inflate(LayoutInflater.from(context),parent,false)

        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return NotesList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote =NotesList  [position]
        holder.binding.tvTitle.text = currentNote.title
        holder.binding.tvTitle.isSelected = true

        holder.binding.tvNote.text = currentNote.note
        holder.binding.tvDate.text = currentNote.date
        holder.binding.tvDate.isSelected = true

        holder.binding.itemLayout.setBackgroundColor(holder.itemView.resources.getColor(randomColor(),null))

        holder.binding.itemLayout.setOnClickListener {

            listener.onItemClicked(NotesList[holder.adapterPosition])
        }

        holder.binding.itemLayout.setOnLongClickListener {

            listener.onLongItemClicked(NotesList[holder.adapterPosition],holder.binding.itemLayout)
            true

        }


    }


    fun updateList(newList :List<NotesEntity>){

        FullList.clear()
        FullList.addAll(newList)

        NotesList.clear()
        NotesList.addAll(FullList)
        notifyDataSetChanged()


    }

    fun filterList(search : String){

        NotesList.clear()

        for (item in FullList){

            if (item.title?.lowercase()?.contains(search.lowercase())==true || item.note?.lowercase()?.contains(search.lowercase())==true ){
                NotesList.add(item)
            }

        }

        notifyDataSetChanged()
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


    interface NotesClickListener{
        fun onItemClicked(note: NotesEntity)
        fun onLongItemClicked(note: NotesEntity, linearLayout: LinearLayout)
    }

}