package com.example.app_kotlin_hach.data.repository

import retrofit2.HttpException
import com.example.app_kotlin_hach.data.model.WeatherResponse
import com.example.app_kotlin_hach.data.remote.RetrofitInstance.api
import com.example.app_kotlin_hach.domain.Resource
import java.io.IOException

class WeatherRepository {

    suspend fun getWeather(city: String): Resource<WeatherResponse> {
        return try {

            val response = api.getWeather(city, "1b46823b29ddc95b6da826a231985bec")

            if (response.isSuccessful) {

                response.body()?.let {
                    Resource.Success(it)
                } ?: Resource.Error("Respuesta vacía")

            } else {
                Resource.Error("Error HTTP: ${response.code()}")
            }

        } catch (e: IOException) {
            Resource.Error("Sin internet")
        } catch (e: HttpException) {
            Resource.Error("Error servidor")
        } catch (e: Exception) {
            Resource.Error("Error inesperado")
        }
    }
}

