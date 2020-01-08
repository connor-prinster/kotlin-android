package com.prinster.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.prinster.notes.adapter.NoteListAdapter
import com.prinster.notes.note.Note
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var notes: ArrayList<Note> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotes()

        note_list_rv.layoutManager = LinearLayoutManager(this)
        note_list_rv.adapter = NoteListAdapter(notes, this)
    }

    private fun createNotes() {
        notes = arrayListOf(
            Note("title0", "string"),
            Note("title1", "string"),
            Note("title2", "string"),
            Note("title3", "string"),
            Note("title4", "string"),
            Note("title5", "string")
        )
    }
}
