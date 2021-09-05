package com.example.todoapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(val context: Context, val listner: ItemClicked) :
    RecyclerView.Adapter<NoteViewHolder>() {

    val allNotes = ArrayList<Notes>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false)
        val mViewHolder = NoteViewHolder(view)
        mViewHolder.dlt.setOnClickListener {
            listner.onItemClicked(allNotes[mViewHolder.adapterPosition])
        }
        return mViewHolder
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currItem = allNotes[position].text
        holder.tv.text = currItem
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateList(newList:List<Notes>){
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }
}

class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val tv: TextView = itemView.findViewById(R.id.tv)
    val dlt: ImageView = itemView.findViewById(R.id.dlt)

}

interface ItemClicked {

    fun onItemClicked(notes: Notes)
}
