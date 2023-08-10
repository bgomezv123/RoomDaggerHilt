package com.example.room_dagger.domain.sensor.model

import com.example.room_dagger.data.sensor.SensorRepository
import javax.inject.Inject

class AddSensor @Inject constructor(
    private val sensorRepository: SensorRepository
){
    suspend operator fun invoke(sensorDomain: SensorDomain){
        sensorRepository.insertSensor(sensorDomain.toSensor())
    }
}