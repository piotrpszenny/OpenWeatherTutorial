package com.example.openweathertutorial.repository

import com.example.openweathertutorial.repository.api.WeatherApi
import com.example.openweathertutorial.repository.db.WeatherDao
import com.example.openweathertutorial.repository.db.data.Weather
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class WeatherRepository (val weatherApi: WeatherApi, val weatherDao: WeatherDao) {
    fun getWeather(): Observable<List<Weather>> {
        return Observable.concatArray(
            getWeatherFromApi()
        )
    }

    private fun getWeatherFromApi(): Observable<List<Weather>> {
        return weatherDao.getWeather().filter { it.isNotEmpty() }
            .toObservable()
            .doOnNext {
                Timber.d("dispatching ${it.size} weathers from DB...")
            }
    }

}

