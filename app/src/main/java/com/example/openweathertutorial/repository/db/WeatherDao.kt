package com.example.openweathertutorial.repository.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.example.openweathertutorial.repository.db.data.Weather
import io.reactivex.Single

@Dao
interface WeatherDao {

    @Query("SELECT * FROM weather")
    fun getWeather(): Single<List<Weather>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(weather: List<Weather>)

}
