package com.example.room_dagger

import android.annotation.SuppressLint
import android.os.Bundle
import android.provider.ContactsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.room_dagger.data.sensor.local.SensorDao
import com.example.room_dagger.data.sensor.model.Sensor
import com.example.room_dagger.domain.sensor.model.SensorDomain
import com.example.room_dagger.ui.theme.Room_daggerTheme
import com.example.room_dagger.views.AddScreen
import com.example.room_dagger.views.HomeScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)



        setContent {
            Room_daggerTheme {
                val navController = rememberNavController()
                val sensorViewModel: SensorViewModel = hiltViewModel()


                NavHost(navController = navController, startDestination = MainDestinations.HomeScreen.route) {
                    composable(MainDestinations.HomeScreen.route) {

                        HomeScreen(
                            onNavigate = {screen -> navigate(navHostController = navController, screen=screen)},
                            sensorState = sensorViewModel.state.value
                        )

                    }
                    composable(MainDestinations.AddScreen.route) {
                        AddScreen()
                    }

                }


            }
        }
    }

    private fun navigate(navHostController: NavHostController, screen : MainDestinations){
        navHostController.navigate(screen.route){
            popUpTo(navHostController.graph.findStartDestination().id){
                saveState = true
            }
            launchSingleTop = true
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Room_daggerTheme {
        Greeting("Android")
    }
}