package com.example.app_kotlin_hach.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material3.Button
import androidx.compose.material3.Text

@Composable
fun HomeScreen(navController: NavController) {
    Button(onClick = {
        navController.navigate("projects")
    }) {
        Text("Ver proyectos")
    }
}