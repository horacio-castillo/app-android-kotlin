package com.example.app_kotlin_hach.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.app_kotlin_hach.models.HomeItem

@Composable
fun HomeScreen(navController: NavController) {

    val items = listOf(
        HomeItem("Ver proyectos", "projects"),
        HomeItem("Clima", "weather"),
        HomeItem("Perfil", "linkedin")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(items) { item ->
            Button(
                onClick = {
                    navController.navigate(item.route)
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(item.title)
            }
        }
    }
}