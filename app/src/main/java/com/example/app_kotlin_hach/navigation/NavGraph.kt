package com.example.app_kotlin_hach.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app_kotlin_hach.ui.home.HomeScreen
import com.example.app_kotlin_hach.ui.linkedin.LinkedInScreen
import com.example.app_kotlin_hach.ui.login.LoginScreen
import com.example.app_kotlin_hach.ui.weather.WeatherScreen

@Composable
fun AppNavigation(onToggleTheme: () -> Unit) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "home") {

        composable("home") {
            HomeScreen(
                navController = navController,
                onToggleTheme = onToggleTheme
            )
        }

        composable("linkedin") {
            LinkedInScreen()
        }

        composable("weather") {
            WeatherScreen()
        }

        composable("login") {
            LoginScreen()
        }
    }
}