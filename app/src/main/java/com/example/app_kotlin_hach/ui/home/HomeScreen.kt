package com.example.app_kotlin_hach.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.app_kotlin_hach.models.HomeItem

@Composable
fun HomeScreen(
    navController: NavController,
    onToggleTheme: () -> Unit
) {

    val items = listOf(
        HomeItem("Login", "login"),
        HomeItem("Clima", "weather"),
        HomeItem("Perfil", "linkedin")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {

        Button(onClick = onToggleTheme) {
            Text("Cambiar tema")
        }

        LazyColumn(
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
}