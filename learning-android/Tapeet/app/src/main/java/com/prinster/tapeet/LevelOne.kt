package com.prinster.tapeet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import androidx.core.view.*

class LevelOne : AppCompatActivity() {

    var width = 0
    var height = 0
    var buttonArray = ArrayList<Button>()
    private val buttonsPerRow = 5
    private val numRows = 5
    private val totalButtons = numRows * buttonsPerRow


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_level_one)
        getScreenData()
        generateButtons()

        val parent = findViewById<LinearLayout>(R.id.parent_ll)

        for(i in 0..(numRows - 1)) {
            val linearLayout = LinearLayout(this)
            linearLayout.orientation = LinearLayout.HORIZONTAL

            for(j in 0..(buttonsPerRow - 1)) {
                val button = buttonArray.get(index = (i * buttonsPerRow) + j)
                linearLayout.addView(button)
            }
            parent.addView(linearLayout)
        }
    }

    private fun getScreenData() {
        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        width = displayMetrics.widthPixels
        height = displayMetrics.heightPixels
    }

    private fun generateButtons() {

        val buttonArr = ArrayList<Button>()

        val buttonWidth = (width) / buttonsPerRow
//        val buttonHeight = (height) / buttonsPerRow

        for(i in 1..totalButtons) {
            val button = Button(this)
            button.width = buttonWidth
            button.height = buttonWidth

            button.background = getDrawable(R.drawable.standard_button)
            buttonArr.add(button)
        }

        buttonArray = buttonArr
    }
}
