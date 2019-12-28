package com.prinster.calculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var firstNumber : String? = null
    var method : String? = null
    var secondNumber : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zero.setOnClickListener { numberClick(zero.id) }
        one.setOnClickListener { numberClick(one.id) }
        two.setOnClickListener { numberClick(two.id) }
        three.setOnClickListener { numberClick(three.id) }
        four.setOnClickListener { numberClick(four.id) }
        five.setOnClickListener { numberClick(five.id) }
        six.setOnClickListener { numberClick(six.id) }
        seven.setOnClickListener { numberClick(seven.id) }
        eight.setOnClickListener { numberClick(eight.id) }
        nine.setOnClickListener { numberClick(nine.id) }

        ac.setOnClickListener { methodClick(ac.id) }
        posNeg.setOnClickListener { methodClick(posNeg.id) }
    }

    fun numberClick(buttonId: Int) {
        var numberValue:String? = null

        when(buttonId) {
            zero.id -> {
                numberValue = "0"
                addNumber(numberValue)
            }
            one.id -> {
                numberValue = "1"
                addNumber(numberValue)
            }
            two.id -> {
                numberValue = "2"
                addNumber(numberValue)
            }
            three.id -> {
                numberValue = "3"
                addNumber(numberValue)
            }
            four.id -> {
                numberValue = "4"
                addNumber(numberValue)
            }
            five.id -> {
                numberValue = "5"
                addNumber(numberValue)
            }
            six.id -> {
                numberValue = "6"
                addNumber(numberValue)
            }
            seven.id -> {
                numberValue = "7"
                addNumber(numberValue)
            }
            eight.id -> {
                numberValue = "8"
                addNumber(numberValue)
            }
            nine.id -> {
                numberValue = "9"
                addNumber(numberValue)
            }
            else -> {
                Log.d("Button: ", "Invalid press $buttonId")
            }
        }
    }

    fun methodClick(buttonId: Int) {
        var methodValue:String? = null

        when(buttonId) {
            ac.id -> {
                clearNumber()
            }
            posNeg.id -> {
                posNeg()
            }
            else -> {
                Log.d("issue", "invalid")
            }
        }
    }

    private fun addNumber(numberVal: String) {
        Log.d("adding number", "adding $numberVal")
        val inputText = findViewById<EditText>(R.id.inputText)
        var newValue: String = inputText.text.toString() + numberVal
        inputText.setText(newValue)
    }

    private fun clearNumber() {
        Log.d("Button press", "clearing value")
        val inputText = findViewById<EditText>(R.id.inputText)
        inputText.setText("")
    }

    fun posNeg() {
        val inputText = findViewById<EditText>(R.id.inputText)
        val inputString = inputText.text.toString()
        var newValue = ""
        var firstChar = ""
        if(inputString != "") {
            firstChar = inputString[0].toString()
            if(firstChar == "-") {
                newValue = inputString.substring(1)
            }
            else {
                newValue = "-$inputString"
            }
            inputText.setText(newValue)
        }
    }
}
