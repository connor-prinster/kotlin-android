package com.prinster.calculator

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val MOD:String = "%"
    val DIV:String = "/"
    val MULT:String = "x"
    val MIN:String = "-"
    val PLUS:String = "+"

    var firstNumber : Double? = null
    var method : String? = null
    var secondNumber : Double? = null

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
        mod.setOnClickListener { methodClick(mod.id) }
        div.setOnClickListener { methodClick(div.id) }
        multiply.setOnClickListener { methodClick(multiply.id) }
        minus.setOnClickListener { methodClick(minus.id) }
        plus.setOnClickListener { methodClick(plus.id) }
        equals.setOnClickListener { methodClick(equals.id) }
        dot.setOnClickListener { methodClick(dot.id) }
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
            mod.id -> {
                setMethodType(MOD)
            }
            div.id -> {
                setMethodType(DIV)
            }
            multiply.id -> {
                setMethodType(MULT)
            }
            minus.id -> {
                setMethodType(MIN)
            }
            plus.id -> {
                setMethodType(PLUS)
            }
            equals.id -> {
                performMethod()
            }
            dot.id -> {
                doDot()
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
        setNull()
        val inputText = findViewById<EditText>(R.id.inputText)
        val methodInput = findViewById<TextView>(R.id.methodInput)
        inputText.setText("")
        methodInput.text = ""
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

    private fun setMethodType(methodString: String) {
        val inputText = findViewById<EditText>(R.id.inputText)
        val methodInput = findViewById<TextView>(R.id.methodInput)
        var inputString = inputText.text.toString()

        if(inputString != "" && firstNumber == null && method == null) {
            firstNumber = inputString.toDouble()
            this.method = methodString
            val newVal = "$inputString $methodString "
            methodInput.text = newVal
            inputText.setText("")
        }
        else if (inputString == ""){
            Toast.makeText(this, "No input text", Toast.LENGTH_LONG).show()
        }
        else {
            Toast.makeText(this, "Method already chosen, press the ${getString(R.string.ac)} button if you wish to change method", Toast.LENGTH_SHORT).show()
        }
    }

    private fun performMethod() {
        val inputText = findViewById<EditText>(R.id.inputText)
        val methodInput = findViewById<TextView>(R.id.methodInput)
        val inputString = inputText.text.toString()
        if(inputString != "") {

            var finalVal = 0.0
            secondNumber = inputString.toDouble()
            val methodText = methodInput.text.toString()
            when(method) {
                MOD -> {
                    finalVal = (firstNumber!!.toInt() % secondNumber!!.toInt()).toDouble()
                }
                DIV -> {
                    finalVal = (firstNumber!! / secondNumber!!)
                }
                MULT -> {
                    finalVal = (firstNumber!! * secondNumber!!)
                }
                MIN -> {
                    finalVal = (firstNumber!! - secondNumber!!)
                }
                PLUS -> {
                    finalVal = (firstNumber!! + secondNumber!!)
                }
            }
            methodInput.text = "$methodText $secondNumber = $finalVal"
            setNull()
            inputText.setText("")
        }
    }

    private fun setNull() {
        firstNumber = null
        secondNumber = null
        method = null
    }

    private fun doDot() {
        val inputText = findViewById<EditText>(R.id.inputText)
        var inputString = inputText.text.toString()
        if(inputString.matches("[.]".toRegex())) {
            Toast.makeText(this, "Multiple decimals are not allowed", Toast.LENGTH_LONG).show()
        }
        else {
            inputString += "."
            inputText.setText(inputString)
        }

    }
}
