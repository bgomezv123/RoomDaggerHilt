package com.example.room_dagger.data.sensor.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Sensor(
    @PrimaryKey(autoGenerate = true)  val id: Int=0,
    val date: String,
    val time: String,
    val value: Int,
    val unit: String,
    val notes: String
)