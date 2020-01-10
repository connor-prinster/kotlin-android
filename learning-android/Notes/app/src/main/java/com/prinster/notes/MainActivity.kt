package com.prinster.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.prinster.notes.adapter.NoteListAdapter
import com.prinster.notes.addNote.AddNote
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.note_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.add_note_menu -> {
                val addNoteIntent = Intent(this, AddNote::class.java)
                startActivity(addNoteIntent)
            }
            R.id.search_note_menu -> {
                makeClickedToast("search note menu")
            }
        }

        return super.onOptionsItemSelected(item)
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

    fun makeClickedToast(message: String) {
        Toast.makeText(this, "You clicked on $message", Toast.LENGTH_SHORT).show()
    }
}
