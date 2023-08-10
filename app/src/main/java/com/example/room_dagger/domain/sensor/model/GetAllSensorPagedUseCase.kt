package com.example.room_dagger.domain.sensor.model

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.paging.map
import com.example.room_dagger.data.sensor.SensorRepository
import com.example.room_dagger.data.sensor.model.Sensor
import dagger.Component.Factory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

import javax.inject.Inject


class GetAllSensorPagedUseCase @Inject constructor(
    private val sensorRepository: SensorRepository

) {
     operator fun invoke(): Flow<PagingData<SensorDomain>> = Pager(
        PagingConfig(
            pageSize = 10,
            prefetchDistance =20
        )
    ){
        sensorRepository.getAllSensorPaging()
    }
        .flow.map {
            value: PagingData<Sensor> ->
            value.map {
                sensor : Sensor->
                sensor.toSensorDomain()
            }

    }
}