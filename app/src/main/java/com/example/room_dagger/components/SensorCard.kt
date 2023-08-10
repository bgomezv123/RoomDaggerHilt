package com.example.room_dagger.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.room_dagger.domain.sensor.model.SensorDomain

@Composable
fun SensorCard(
    modifier: Modifier = Modifier,
    sensorDomain: SensorDomain,
    onSelectedSensorDomain: (sensorDomain: SensorDomain)-> Unit
) {

    Card(
        modifier = Modifier.clickable { onSelectedSensorDomain(sensorDomain)},

    ) {
        Column (modifier = Modifier.fillMaxWidth()) {
            Text(text = "Date : "+sensorDomain.date)
            Text(text = "Time : "+sensorDomain.time)
            Text(text = "Value : "+sensorDomain.value.toString())
            Text(text = "Unit : "+sensorDomain.unit)
            Text(text = "Notes : "+sensorDomain.notes)
        }
    }


}