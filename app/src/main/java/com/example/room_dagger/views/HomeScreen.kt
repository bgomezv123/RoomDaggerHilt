package com.example.room_dagger.views


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.room_dagger.MainDestinations
import com.example.room_dagger.SensorState
import com.example.room_dagger.components.SensorList
import com.example.room_dagger.domain.sensor.model.SensorDomain
import com.example.room_dagger.ui.theme.Room_daggerTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onNavigate: (MainDestinations)->Unit,
    sensorState: SensorState,

    ){

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.White,
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { onNavigate(MainDestinations.AddScreen)},
                containerColor = Color.Green
                ) {
                Text(text = "Add")
            }
        }
    ){
        SensorList(modifier = Modifier.padding(it),sensorDomains = sensorState.sensors, onSelectedSensorDomain = {} )
        Column(modifier = Modifier.padding(it)) {

        }
    }

}


