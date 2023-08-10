package com.example.room_dagger.domain.sensor.model

import com.example.room_dagger.data.sensor.SensorRepository
import javax.inject.Inject

class GetSensors @Inject constructor(
    private val sensorRepository: SensorRepository
) {
    suspend operator fun invoke(): List<SensorDomain>{
        return sensorRepository.getAllSensor().map {
            it.toSensorDomain()
        }
    }
}