package com.example.mapapp

sealed class Routes(val route: String) {
    object Splash: Routes("splash")
    object Pantalla2: Routes("pantalla2")
    object Pantalla3: Routes("pantalla3")
}
