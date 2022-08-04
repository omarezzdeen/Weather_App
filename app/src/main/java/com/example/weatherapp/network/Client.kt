package com.example.weatherapp.network

import android.util.Log
import com.example.weatherapp.DataManager
import com.example.weatherapp.data.Weather
import com.example.weatherapp.ui.avivity.MainActivity
import com.example.weatherapp.util.Constants
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class Client(val dataManager: DataManager) {
    val client = OkHttpClient()

    fun makeRequestWithOkHTTP(setupRecycler: () -> Unit) {
        val request = Request.Builder().url(Constants.baseUrlWeather).build()
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                Log.i(Constants.TAG, "fail: ${e.message}")
            }
            override fun onResponse(call: Call, response: Response) {
                response.body?.string().let { jsonString ->
                    val result = Gson().fromJson(jsonString, Weather::class.java)
                    dataManager.saveWeatherData(result)
                    Log.i(Constants.TAG, "data=>: $result")
                }
                setupRecycler()
            }

        })
    }
}