package com.example.weatherapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val checkWeather = findViewById<Button>(R.id.checkWeather)
        val zipCode = findViewById<EditText>(R.id.zipCode)

        checkWeather?.setOnClickListener(){
            Log.d("MainActivity", "onCheckWeather")
            val zipCodeVal = zipCode.text.toString()
            if(zipCodeVal.length > 5){
                Toast.makeText(applicationContext, "Invalid zip code: [$zipCodeVal], please enter 5 digit zip", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this,WeatherActivity::class.java).apply{putExtra("key",zipCodeVal)}
                startActivity(intent)
            }
        }
    }
}