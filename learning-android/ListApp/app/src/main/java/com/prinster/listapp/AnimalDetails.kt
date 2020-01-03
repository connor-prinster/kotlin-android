package com.prinster.listapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_animal_details.*

class AnimalDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_details)

        val bundle: Bundle = intent.extras
        val animalType = bundle.getString("type")
        val animalDesc = bundle.getString("desc")
        val animalImg: Int = bundle.getInt("img")
        animal_image.setImageDrawable(ContextCompat.getDrawable(this, animalImg))
        animal_type.text = animalType
        animal_desc.text = animalDesc



    }
}
