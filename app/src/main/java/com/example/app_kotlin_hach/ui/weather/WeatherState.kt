package com.example.app_kotlin_hach.ui.weather

import androidx.compose.runtime.Composable
import com.example.app_kotlin_hach.data.model.WeatherResponse

sealed class WeatherState {
    object Loading : WeatherState()
    data class Success(val data: WeatherResponse) : WeatherState()
    data class Error(val message: String) : WeatherState()
}