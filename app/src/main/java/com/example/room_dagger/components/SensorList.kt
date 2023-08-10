package com.example.room_dagger.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.room_dagger.domain.sensor.model.SensorDomain

@Composable
fun SensorList(
    modifier: Modifier = Modifier,
    sensorDomains: List<SensorDomain>,
    onSelectedSensorDomain: (sensorDomain: SensorDomain)-> Unit
) {
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ){
        items(items = sensorDomains) {
            sensorDomains->
            SensorCard(modifier = modifier.height(100.dp).fillMaxSize(),sensorDomain = sensorDomains, onSelectedSensorDomain = onSelectedSensorDomain)

        }
    }

}