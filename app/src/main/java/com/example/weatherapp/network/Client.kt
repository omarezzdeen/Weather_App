package com.example.weatherapp.network

import android.util.Log
import com.example.weatherapp.DataManager
import com.example.weatherapp.data.model.State
import com.example.weatherapp.data.model.Weathers
import com.example.weatherapp.util.Constants
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

object Client {
    private val client = OkHttpClient()

    fun getWeatherData(): State<Weathers.WeatherModel?> {
        val request = Request.Builder().url(getWeatherUrl()).build()
        val response = client.newCall(request).execute()
        return if(response.isSuccessful){
            val result = Gson().fromJson(response.body?.string(), Weathers.WeatherModel::class.java)
            State.Success(result)
        }else{
            State.Error(response.message)
        }
    }


    private fun getWeatherUrl(): HttpUrl {
        return HttpUrl.Builder()
            .scheme(Constants.PROTOCOL)
            .host(Constants.HOST)
            .addPathSegments("data/2.5/onecall")
            .addQueryParameter(Constants.LAT, "31.51667")
            .addQueryParameter(Constants.LON, "34.48333")
            .addQueryParameter(Constants.APPID, Constants.KEY)
            .addQueryParameter(Constants.UNITS, "metric")
            .build()
    }
}