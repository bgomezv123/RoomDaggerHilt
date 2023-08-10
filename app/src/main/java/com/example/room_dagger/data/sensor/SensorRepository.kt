package com.example.room_dagger.data.sensor

import androidx.paging.PagingSource
import com.example.room_dagger.data.sensor.local.SensorDao
import com.example.room_dagger.data.sensor.model.Sensor
import javax.inject.Inject

class SensorRepository @Inject constructor(
    private val sensorDao: SensorDao
) {

    fun getAllSensor(): List<Sensor>{
        return sensorDao.getAll()
    }

    fun getAllSensorPaging(): PagingSource<Int, Sensor>{
        return sensorDao.getAllPaging()
    }
    fun insertSensor(sensor: Sensor){
        sensorDao.insert(sensor)
    }

    fun updateSensor(sensor: Sensor){
        sensorDao.update(sensor)
    }

    fun deleteSensor(sensor: Sensor){
        sensorDao.delete(sensor)
    }
}