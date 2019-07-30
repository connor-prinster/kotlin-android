package com.prinster.findmyage

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

  var cal = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)

      goButton.setOnClickListener {
        val inputYear = enterDob.text.toString()
        val currentYear = Calendar.getInstance().get(Calendar.YEAR)
        if(inputYear.isEmpty()) {
          Toast.makeText(
            applicationContext,
            R.string.empty_input,
            Toast.LENGTH_SHORT
          ).show()
        } else if(Integer.parseInt(inputYear) > currentYear) {
          Toast.makeText(
            applicationContext,
            R.string.future_error,
            Toast.LENGTH_SHORT
          ).show()
        } else {
          ageResult.text =
            getString(
              R.string.result_text,
              (currentYear - Integer.parseInt(inputYear)).toString())
        }
      }
    }
}
