package com.example.app_kotlin_hach.data.remote

import android.text.BoringLayout.Metrics
import androidx.compose.ui.unit.TextUnit
import com.example.app_kotlin_hach.data.model.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") unit: String = "metric"
    ): WeatherResponse
}