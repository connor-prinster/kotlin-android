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
    }

    fun numberClick(view:View) {
        val selectedButton = view as Button
        var numberValue:String? = null

        when(selectedButton.id) {
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
                Log.d("Button pressed", "Invalid press ${selectedButton.id}")
            }
        }
    }

    fun methodClick(view:View) {
        val selectedButton = view as Button
        var methodValue:String? = null

        when(selectedButton.id) {
            ac.id -> {
                clearNumber()
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

    fun clearNumber() {
        Log.d("Button press", "clearing value")
        val inputText = findViewById<EditText>(R.id.inputText)
        inputText.setText("")
    }

    fun posNeg(view:View) {
        Log.d("Button press", "posNeg")
        val inputText = findViewById<EditText>(R.id.inputText)
        val inputTextString = inputText.toString()
        var newString = ""
        if(inputTextString[0] == '-') {
            newString = inputTextString.replace("-", "")
        }
        else {
            newString = "-$inputTextString"
        }
        inputText.setText(newString)
    }
}
