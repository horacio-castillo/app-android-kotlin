package com.example.app_kotlin_hach.ui.weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = viewModel()) {

    val state = viewModel.weatherState.collectAsState().value

    Box(modifier = Modifier.fillMaxSize() .background(Color(0xFF87CEEB))) {

        Column(
            modifier = Modifier
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            when (state) {

                is WeatherState.Loading -> {
                    Text("Cargando clima...")
                }

                is WeatherState.Success -> {
                    Text("Ciudad: ${state.data.name}")
                    Text("Temperatura: ${state.data.main.temp}")
                }

                is WeatherState.Error -> {
                    Text("Error: ${state.message}")
                }
            }
        }

        Button(
            onClick = {
                viewModel.loadWeather("Monterrey")
            },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(16.dp)
        ) {
            Text("Cargar clima")
        }
    }
}