package com.prinster.sunrisesunset

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

class MainActivity : AppCompatActivity() {

//    let ipBase = "http://api.ipstack.com/check?";
//    let ipKey = "access_key=0a4cf349f3dcf47097f78db5e8b1b59d";
//    let ipReq = ipBase + ipKey;
//
//    let weatherBase = "http://api.openweathermap.org/data/2.5/";
//    let forecastBase = "forecast?zip=";
//    let currentBase = "weather?zip=";
//    let usEnd = ",us";
//
//    let imperial = "&units=imperial";
//    let weatherKey = "&appid=e41aa422f8716c96e716374177d4fbd8";

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getMethod = get_method as Button
        val myUrl:String = "http://api.openweathermap.org/data/2.5/weather?q=London&appid=e41aa422f8716c96e716374177d4fbd8"
        getMethod.setOnClickListener{HTTPAsyncTask().execute(myUrl)}

    }

    //view: View
    private fun findSunset(myUrl: String):String {
        val inputStream: InputStream
        var result = ""
        val url= URL(myUrl)
        val conn: HttpURLConnection = url.openConnection() as HttpURLConnection
        conn.connect()
        inputStream = conn.inputStream

        if(inputStream != null) {
            result = convertInputStreamToString(inputStream)
        }
        else {
            Log.d("Error", "DID NOT WORK!")
        }

        return result
    }

    inner class HTTPAsyncTask: AsyncTask<String, String, String>() {
        override fun doInBackground(vararg urls: String?): String {
            return findSunset(urls[0]!!)
        }

        @SuppressLint("SetTextI18n")
        override fun onPostExecute(result: String?) {
            if(result != null) {
                val json = JSONObject(result)
                Log.d("json", json.toString())

                val sys = json.getJSONObject("sys")
                val sunrise = sys.getLong("sunrise")
                val sunset = sys.getLong("sunset")

                sunrise_text.text = returnSunrise(sunrise)
                sunset_text.text = returnSunset(sunset)
            }
            else {
                sunset_text.text = "error in json"
            }

        }
    }

    fun returnSunset(sunrise: Long): String {
        val riseDate = Date(sunrise * 1000)
        val riseCal: Calendar = Calendar.Builder().setInstant(riseDate).build()
        return " ${riseCal.get(Calendar.MONTH) + 1}/${riseCal.get(Calendar.DAY_OF_MONTH)}/${riseCal.get(Calendar.YEAR)}"
    }

    fun returnSunrise(sunset: Long): String {
        val setDate = Date(sunset * 1000)
        val setCal: Calendar = Calendar.Builder().setInstant(setDate).build()
        return " ${setCal.get(Calendar.MONTH) + 1}/${setCal.get(Calendar.DAY_OF_MONTH)}/${setCal.get(Calendar.YEAR)}"
    }

    private fun convertInputStreamToString(inputStream: InputStream):String {
        val bufferReader = BufferedReader(InputStreamReader(inputStream))
        var allString = ""

        try {
            bufferReader.use {
                it.lines().forEach{ line -> allString += line }
            }
        }
        catch (ex: Exception) {
            Log.d("exception in convertInputStreamToString", ex.toString())
        }

        return allString
    }
}

