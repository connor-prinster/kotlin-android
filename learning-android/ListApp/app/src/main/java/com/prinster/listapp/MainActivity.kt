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

    private fun createAnimalList() {
        animals = arrayListOf(
            Animal(R.drawable.baboon, "Baboon", "A baboon"),
            Animal(R.drawable.bulldog, "Bulldog", "A bulldog"),
            Animal(R.drawable.panda, "Panda", "A panda"),
            Animal(R.drawable.swallow_bird, "Swallow", "A swallow"),
            Animal(R.drawable.white_tiger, "White Tiger", "A white tiger"),
            Animal(R.drawable.zebra, "Zebra", "A zebra")

        )
//            "Bulldog",
//            "Panda",
//            "Swallow",
//            "White Tiger",
//            "Zebra")
    }
}
