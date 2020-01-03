package com.prinster.listapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var animals : ArrayList<Animal> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createAnimalList()

        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.adapter = AnimalListAdapter(animals, this)
    }

    fun delete(index: Int) {
        animals.removeAt(index)
        rv_list.adapter!!.notifyDataSetChanged()
    }

    fun add(index: Int) {
        animals.add(animals[index])
        rv_list.adapter!!.notifyDataSetChanged()
    }

    private fun createAnimalList() {
        animals = arrayListOf(
            Animal(R.drawable.baboon, "Baboon", "A baboon", true),
            Animal(R.drawable.bulldog, "Bulldog", "A bulldog", false),
            Animal(R.drawable.panda, "Panda", "A panda", false),
            Animal(R.drawable.swallow_bird, "Swallow", "A swallow", false),
            Animal(R.drawable.white_tiger, "White Tiger", "A white tiger", true),
            Animal(R.drawable.zebra, "Zebra", "A zebra", false)
        )
    }
}
