package com.example.app_kotlin_hach.data.repository

import com.example.app_kotlin_hach.data.model.WeatherResponse
import com.example.app_kotlin_hach.data.remote.RetrofitInstance

class WeatherRepository {

    suspend fun getWeather(city: String): WeatherResponse {
        return RetrofitInstance.api.getWeather(
            city,
            "1b46823b29ddc95b6da826a231985bec"
        )
    }
}