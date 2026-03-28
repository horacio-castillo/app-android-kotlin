package com.example.app_kotlin_hach.ui.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_kotlin_hach.data.repository.WeatherRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val repository = WeatherRepository()

    private val _weatherState = MutableStateFlow<WeatherState>(WeatherState.Loading)
    val weatherState: StateFlow<WeatherState> = _weatherState

    fun loadWeather(city: String) {
        viewModelScope.launch {

            _weatherState.value = WeatherState.Loading

            try {
                val response = repository.getWeather(city)
                _weatherState.value = WeatherState.Success(response)

            } catch (e: Exception) {
                _weatherState.value =
                    WeatherState.Error(e.message ?: "Error desconocido")
            }
        }
    }
}