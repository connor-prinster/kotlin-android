package com.prinster.notes.addNote

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.prinster.notes.R
import com.prinster.notes.database.DbManager
import kotlinx.android.synthetic.main.add_note.*

class AddNote : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_note)

        add_note.setOnClickListener { addNote() }
        discard_note.setOnClickListener (View.OnClickListener {
            var dbManager = DbManager(applicationContext)
        })

    }

    private fun addNote() {
        val dbName = "MyNotes"
        val dbManager = DbManager(this)
        val values = ContentValues()
        values.put("Title", note_title.text.toString())
        values.put("Content", note_content.text.toString())
        val id = dbManager.insert(values)
        if(id > 0) {
            Toast.makeText(this, "Note Added to List!", Toast.LENGTH_SHORT).show()
        }
        else {
            Toast.makeText(this, "Adding Note Failed!", Toast.LENGTH_LONG).show()
        }

        finish()
    }

    private fun discardNote() {
        Toast.makeText(this, "Note Discarded!", Toast.LENGTH_SHORT).show()
        finish()
    }


}
