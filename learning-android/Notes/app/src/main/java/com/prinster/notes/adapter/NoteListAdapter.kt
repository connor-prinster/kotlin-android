package com.prinster.notes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.prinster.notes.R
import com.prinster.notes.note.Note
import kotlinx.android.synthetic.main.note_ticket.view.*

class NoteListAdapter(private val notes: ArrayList<Note>, private val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        return notes.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.note_ticket, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentNote: Note = notes[position]

        holder.title.text = currentNote.returnTitle()
        holder.content.text = currentNote.returnContent()

        holder.editButton.setOnClickListener { Toast.makeText(context, "Clicked edit button on ${holder.title.text}", Toast.LENGTH_SHORT).show() }
        holder.deleteButton.setOnClickListener { Toast.makeText(context, "Clicked delete button on ${holder.title.text}", Toast.LENGTH_SHORT).show() }
    }
}

class ViewHolder (private val view: View) : RecyclerView.ViewHolder(view) {

    var title = view.title_text!!
    var content = view.content_text!!

    var editButton = view.edit_button!!
    var deleteButton = view.delete_button!!

}