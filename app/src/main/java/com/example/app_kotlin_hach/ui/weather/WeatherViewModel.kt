package com.example.app_kotlin_hach.ui.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_kotlin_hach.data.repository.WeatherRepository
import com.example.app_kotlin_hach.domain.Resource
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

            when (val result = repository.getWeather(city)) {

                is Resource.Success -> {
                    _weatherState.value = WeatherState.Success(result.data)
                }

                is Resource.Error -> {
                    _weatherState.value = WeatherState.Error(result.message)
                }

                is Resource.Loading -> {
                    _weatherState.value = WeatherState.Loading
                }
            }
        }
    }
}