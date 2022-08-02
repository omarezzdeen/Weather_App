package com.example.weatherapp.ui.avivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.weatherapp.data.Weather
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.DataManager
import com.example.weatherapp.network.Client
import com.example.weatherapp.util.Constants
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val dataManager = DataManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }


    private fun setup() {
        val okHttp = Client(dataManager)
        okHttp.makeRequestWithOkHTTP {
            runOnUiThread {
              callBak(dataManager.dataList!!)
            }
        }


        }
    private fun callBak(data: Weather) {
        val visibility = data.visibility/1000
        val pressure = data.main.pressure/100.0
        binding.apply {
            textMain.text = data.weather[0].main
            textDescription.text = data.weather[0].description
            textTemp.text = data.main.temp.toString()
            textHumidity.text = data.main.humidity.toString()
            textPressure.text = data.main.pressure.toString()
            textTempMin.text = data.main.temp_min.toString()
            textTempMax.text = data.main.temp_max.toString()
            textFeelsLike.text = data.main.feels_like.toString()
            textWind.text = data.wind.speed.toString()
            textVisibility.text = visibility.toString()
            textPressure.text = pressure.toString()
        }
    }

}
