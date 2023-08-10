package com.example.room_dagger.data.sensor.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.room_dagger.data.sensor.model.Sensor

@Database(entities = [Sensor::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun sensorDao(): SensorDao
}