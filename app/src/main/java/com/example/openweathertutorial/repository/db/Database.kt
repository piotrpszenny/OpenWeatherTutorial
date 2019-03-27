package com.example.openweathertutorial.repository.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.example.openweathertutorial.repository.db.data.Weather

@Database(entities = arrayOf(Weather::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}