package com.example.app_kotlin_hach.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.app_kotlin_hach.ui.home.HomeScreen
import com.example.app_kotlin_hach.ui.linkedin.LinkedInScreen
import com.example.app_kotlin_hach.ui.weather.WeatherScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("linkedin") { LinkedInScreen() }
        composable("weather") {  WeatherScreen() }
        //composable("projects") { ProjectsScreen(navController) }
    }
}