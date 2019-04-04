package com.example.openweathertutorial.repository.db.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


data class Weather(
    val name: String,
    val temp: Double
)