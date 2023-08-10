package com.example.room_dagger.domain.sensor.model

import androidx.room.PrimaryKey
import com.example.room_dagger.data.sensor.model.Sensor

data class SensorDomain(
    val id: Int,
    val date: String,
    val time: String,
    val value: Int,
    val unit: String,
    val notes: String
)
fun SensorDomain.toSensor(): Sensor = Sensor(id=id,date=date,time=time,value=value,unit=unit,notes=notes)
fun Sensor.toSensorDomain():SensorDomain = SensorDomain(id=id,date=date,time=time,value=value,unit=unit,notes=notes)