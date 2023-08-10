package com.example.room_dagger

import com.example.room_dagger.domain.sensor.model.SensorDomain

data class SensorState (
    var sensors : List<SensorDomain> = emptyList()
)