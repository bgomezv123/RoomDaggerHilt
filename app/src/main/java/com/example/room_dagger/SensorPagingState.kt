package com.example.room_dagger

import com.example.room_dagger.domain.sensor.model.SensorDomain

data class SensorPagingState (
    var sensors : List<SensorDomain> = emptyList()
)