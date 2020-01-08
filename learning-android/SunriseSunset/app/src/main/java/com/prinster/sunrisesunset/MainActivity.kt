package com.prinster.sunrisesunset

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.net.ConnectException
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val getMethod = get_data as Button
        getMethod.setOnClickListener{
            val input = zip_code_et
            val zipCode = input.text
            if(zipCode.length == 5) {
                val myUrl = "http://api.openweathermap.org/data/2.5/weather?zip=$zipCode,us&appid=e41aa422f8716c96e716374177d4fbd8"
                HTTPAsyncTask().execute(myUrl)
            }
            else {
                showZipErrorToast()
            }
        }
    }

    private fun showZipErrorToast() {
        Toast.makeText(this, "Not a valid zip code", Toast.LENGTH_SHORT).show()
    }

    inner class HTTPAsyncTask: AsyncTask<String, String, String>() {
        override fun doInBackground(vararg urls: String?): String? {
            val myUrl = urls[0]!!
            val inputStream: InputStream
            var result:String? = ""
            val url= URL(myUrl)
            val conn: HttpURLConnection = url.openConnection() as HttpURLConnection
            try {
                conn.connect()

                val responseCode = conn.responseCode
                if(responseCode == HttpURLConnection.HTTP_OK) {
                    inputStream = conn.inputStream
                    result = convertInputStreamToString(inputStream)

                }
                else {
                    result = null
                }
            }
            catch (e: Exception) {
                showZipErrorToast()
                Log.d("something else", e.toString())
            }
            finally {
                conn.disconnect()
            }

            return result
        }

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
                sunrise_text.text = ("${resources.getString(R.string.sunrise_text)} ${getString(R.string.json_error)}")
                sunset_text.text = ("${resources.getString(R.string.sunset_text)} ${getString(R.string.json_error)}")
                showZipErrorToast()
            }

        }
    }

    fun returnSunrise(sunrise: Long): String {
        return "${resources.getString(R.string.sunrise_text)} ${returnTimeStamp(sunrise)}"
    }

    fun returnSunset(sunset: Long): String {
        return "${resources.getString(R.string.sunset_text)} ${returnTimeStamp(sunset)}"
    }

    fun returnTimeStamp(sundata: Long): String {
        val sunDate = Date(sundata * 1000)
        val sunCal: Calendar = Calendar.Builder().setInstant(sunDate).build()
        return "${sunCal.get(Calendar.HOUR_OF_DAY)}:${sunCal.get(Calendar.MINUTE)}:${sunCal.get(Calendar.SECOND)} ${returnAmPm(sunCal.get(Calendar.AM_PM))}"
    }

    fun returnAmPm(ampm: Int): String {
        return when(ampm) {
            0 -> "AM"
            else -> "PM"
        }
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
        finally {
        }

        return allString
    }
}

