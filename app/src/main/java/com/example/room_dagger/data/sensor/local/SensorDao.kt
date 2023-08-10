package com.example.room_dagger.data.sensor.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.room_dagger.data.sensor.model.Sensor

@Dao
interface SensorDao {

    @Query("SELECT * FROM Sensor")
    fun getAll(): List<Sensor>

    @Query("SELECT * FROM Sensor")
    fun getAllPaging(): PagingSource<Int,Sensor>

    @Query("SELECT * FROM Sensor WHERE id = :sensorId")
    fun getById(sensorId: Int): Sensor

    @Insert
    fun insert(sensor: Sensor)

    @Update
    fun update(sensor: Sensor)

    @Delete
    fun delete(sensor: Sensor)
}