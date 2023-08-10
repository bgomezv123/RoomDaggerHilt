package com.example.room_dagger

sealed class MainDestinations(val route: String) {
    object HomeScreen: MainDestinations(route = "home")
    object AddScreen: MainDestinations(route = "add")

}