package com.example.room_dagger.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.room_dagger.ui.theme.Room_daggerTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen() {

    var date by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("") }
    var value by remember { mutableStateOf(0) }
    var unit by remember { mutableStateOf("") }
    var notes by remember { mutableStateOf("") }

    Surface(modifier = Modifier.fillMaxSize(), color = Color.Cyan) {


        Column(modifier = Modifier
            .fillMaxSize()
            .padding(15.dp))
        {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = date,
                onValueChange = {newText -> date = newText},
                label = { Text(text = "date")}
            )
            Spacer(modifier = Modifier.height(15.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = time,
                onValueChange = {newText -> time = newText},
                label = { Text(text = "time")}

            )
            Spacer(modifier = Modifier.height(15.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = value.toString(),
                onValueChange = {newText -> value = newText.toInt()},
                label = { Text(text = "value")}
            )
            Spacer(modifier = Modifier.height(15.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = unit,
                onValueChange = {newText -> unit = newText},
                label = { Text(text = "unit")}
            )
            Spacer(modifier = Modifier.height(15.dp))
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = notes,
                onValueChange = {newText -> notes = newText},
                label = { Text(text = "notes")}
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Save")
                }
            }
        }
    }
}


