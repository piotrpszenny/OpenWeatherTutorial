package com.example.openweathertutorial.repository.api

import com.example.openweathertutorial.repository.db.data.Weather
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface WeatherApi {
    @GET("weather?q={city name}")
    fun getWeather(@Path("city name") cityName:String) : Observable<List<Weather>>

}