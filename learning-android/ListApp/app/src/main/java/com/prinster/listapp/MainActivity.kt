package com.prinster.listapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var animals : ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createAnimalList()

        rv_list.layoutManager = LinearLayoutManager(this)
        rv_list.adapter = RvListAdapter(animals, this)
    }

    private fun createAnimalList() {
        animals = arrayListOf("Baboon", "Bulldog", "Panda", "Swallow", "White Tiger", "Zebra")
    }
}
