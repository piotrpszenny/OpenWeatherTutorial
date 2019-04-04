package com.example.openweathertutorial

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.openweathertutorial.repository.api.WeatherApi

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherApi = WeatherApi.create()
        weatherApi.getWeather("reda")

    }
}
