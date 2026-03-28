package com.example.app_kotlin_hach.data.model

data class WeatherResponse(
    val name: String,
    val main: Main
)

data class Main(
    val temp: Double
)