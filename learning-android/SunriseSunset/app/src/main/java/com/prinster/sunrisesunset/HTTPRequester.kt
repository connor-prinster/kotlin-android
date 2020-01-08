package com.prinster.sunrisesunset

import android.content.Context
import android.os.AsyncTask
import android.util.Log
import android.widget.Toast
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class HTTPRequester(val context: Context) {

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

    private fun showErrorToast() {
        Toast.makeText(context, "Not a valid zip code", Toast.LENGTH_SHORT).show()
    }

    inner class HTTPAsyncTask: AsyncTask<String, String, String>() {
        override fun doInBackground(vararg urls: String?): String? {
            var result:String? = ""

            val myUrl = urls[0]!!
            val inputStream: InputStream
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
                showErrorToast()
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
            }
            else {
                showErrorToast()
            }

        }
    }
}