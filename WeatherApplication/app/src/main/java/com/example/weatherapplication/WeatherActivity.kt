package com.example.weatherapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class WeatherActivity : AppCompatActivity() {
    private val client = OkHttpClient()
    var res = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        val zipCodeVal = this.intent.getStringExtra("key").toString().toInt();
        Log.d("WeatherActivity", zipCodeVal.toString())
        val apiEndPoint = "https://api.openweathermap.org/data/2.5/weather?zip=$zipCodeVal,us&appid=0bbdae186c1032674f1fd0cb8b013348"

        val DATA = findViewById<TextView>(R.id.weatherData)

        val request = Request.Builder()
            .url(apiEndPoint)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response){
                if(response.isSuccessful){
                    val responseVal = JSONObject(response.body()?.string());
                    Log.d("WeatherActivity",responseVal.toString())
                    val city = "City: " + responseVal.get("name").toString()
                    val temp = JSONObject(responseVal.get("main").toString()).get("temp").toString()
                    val tempF = "Current temp (F): " + "%.2f".format(((temp.toDouble() - 273.15) * 9/5 + 32).toFloat())
                    val tempC = "Current temp (C): " + "%.2f".format((temp.toDouble() - 273.15).toFloat())
                    res =  city + "\n"+ tempC + "\n" + tempF + "\n"
                }

            }
        })
    }
}