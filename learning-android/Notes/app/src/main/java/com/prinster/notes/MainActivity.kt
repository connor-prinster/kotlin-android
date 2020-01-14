package com.prinster.notes

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
<<<<<<< HEAD
import com.google.android.gms.ads.MobileAds
=======
>>>>>>> 655dcdcdf36281f4f4a6801feaf50a80ce241da1
import com.prinster.notes.addNote.AddNote
import com.prinster.notes.database.DbManager
import com.prinster.notes.note.Note
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.note_ticket.view.*

class MainActivity : AppCompatActivity() {

    private var notes: ArrayList<Note> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
<<<<<<< HEAD
        MobileAds.initialize(this)
=======
>>>>>>> 655dcdcdf36281f4f4a6801feaf50a80ce241da1

        loadQuery("%")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.note_menu, menu)


        val searchView = menu!!.findItem(R.id.search_note_menu).actionView as? SearchView
        val searchManager = getSystemService(Context.SEARCH_SERVICE) as? SearchManager

        if (searchView != null) {
            searchView.setSearchableInfo(searchManager!!.getSearchableInfo(componentName))
            searchView.setOnQueryTextListener( object: SearchView.OnQueryTextListener {
                override fun onQueryTextChange(p0: String?): Boolean {
    //                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    return false
                }

                override fun onQueryTextSubmit(p0: String?): Boolean {
                    if(p0 != null) {
//                        Toast.makeText(applicationContext, p0, Toast.LENGTH_SHORT).show()
                        loadQuery("%$p0%")
                    }
                    return false
    //                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }
            })
        }

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.add_note_menu -> {
                val addNoteIntent = Intent(this, AddNote::class.java)
                startActivity(addNoteIntent)
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        loadQuery("%")
    }

    private fun updateList(title: String, content: String, id: Int) {
        var intent = Intent(applicationContext, AddNote::class.java)
        intent.putExtra("title", title)
        intent.putExtra("content", content)
        intent.putExtra("id", id)
        startActivity(intent)

    }


    private fun loadQuery(noteTitle:String) {
        val dbManager = DbManager(this)

        val projection = arrayOf("ID", "Title", "Content")
        val selectionArgs = arrayOf(noteTitle) // anything
        val cursor = dbManager.query(projection, "Title like ?", selectionArgs, "Title")

        notes.clear()
        if(cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndex("ID"))
                val title = cursor.getString(cursor.getColumnIndex("Title"))
                val content = cursor.getString(cursor.getColumnIndex("Content"))

                notes.add(Note(title, content, id ))
            } while(cursor.moveToNext())
        }

        note_list_rv.layoutManager = LinearLayoutManager(this)
        note_list_rv.adapter = NoteListAdapter(notes, this)

    }

    inner class NoteListAdapter(private val notes: ArrayList<Note>, private val context: Context) : RecyclerView.Adapter<ViewHolder>() {
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

            holder.editButton.setOnClickListener {

                updateList(currentNote.returnTitle(), currentNote.returnContent(), currentNote.returnID())
            }
            holder.deleteButton.setOnClickListener{
                val dbManager = DbManager(context)
                val selectionArgs: Array<String> = arrayOf(currentNote.returnID().toString())
                dbManager.delete("ID=?", selectionArgs)
                loadQuery("%")
            }
        }
    }

    inner class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

        var title = view.title_text!!
        var content = view.content_text!!

        var editButton = view.edit_button!!
        var deleteButton = view.delete_button!!

    }
}


