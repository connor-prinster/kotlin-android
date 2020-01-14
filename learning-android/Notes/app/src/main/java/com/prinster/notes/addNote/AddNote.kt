package com.prinster.notes.addNote

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.prinster.notes.MainActivity
import com.prinster.notes.R
import com.prinster.notes.database.DbManager
import kotlinx.android.synthetic.main.add_note.*
import java.lang.Exception

class AddNote : AppCompatActivity() {

    var id: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_note)

        add_note.setOnClickListener { addNote() }
        discard_note.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val bundle = intent.extras
        try {
            note_title.setText(bundle.getString("title"))
            note_content.setText(bundle.getString("content"))
            id = bundle.getInt("id")
            add_note.setText(R.string.update_note)
            discard_note.setText(R.string.discard_changes)
        }
        catch(ex: Exception) { }

    }

    private fun addNote() {
<<<<<<< HEAD
//        val dbName = "MyNotes"
=======
        val dbName = "MyNotes"
>>>>>>> 655dcdcdf36281f4f4a6801feaf50a80ce241da1
        val dbManager = DbManager(this)
        val values = ContentValues()
        values.put("Title", note_title.text.toString())
        values.put("Content", note_content.text.toString())
        if(id == 0) {
            val insertId = dbManager.insert(values)
            if(insertId > 0) {
                toastSuccess()
            }
            else {
                toastFailure()
            }
        }
        else {
<<<<<<< HEAD
            val selectionArgs = arrayOf(id.toString())
=======
            val selectionArgs = arrayOf(id!!.toString())
>>>>>>> 655dcdcdf36281f4f4a6801feaf50a80ce241da1
            val updated = dbManager.update(values, "id = ?", selectionArgs)
            if(updated > 0) {
                toastSuccess()
            }
            else {
                toastFailure()
            }
        }

        finish()
    }

    private fun toastSuccess() {
        Toast.makeText(this, "Note Added to List!", Toast.LENGTH_SHORT).show()
    }

    private fun toastFailure() {
        Toast.makeText(this, "Adding Note Failed!", Toast.LENGTH_LONG).show()
    }

    private fun discardNote() {
        Toast.makeText(this, "Note Discarded!", Toast.LENGTH_SHORT).show()
        finish()
    }


}
