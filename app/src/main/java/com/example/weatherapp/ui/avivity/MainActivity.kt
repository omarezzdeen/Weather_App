package com.example.weatherapp.ui.avivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.DataManager
import com.example.weatherapp.network.Client
import com.google.gson.Gson
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val dataManager = DataManager()
    val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Client(dataManager).makeRequestWithOkHTTP {  }
//        setup()
    }

//
//    private fun setup() {
//        val okHttp = Client(dataManager)
//        okHttp.makeRequestWithOkHTTP {
//            runOnUiThread {
//                val adapter = WeatherAdapter(dataManager.dataList)
//                binding.recyclerview.adapter = adapter
////              callBak(dataManager.dataList!!)
//            }
//        }


//        }
//    private fun callBak(data: MyWeather) {
//        val visibility = data.hourly.forEach { it.visibility }
////        val pressure = data.main.pressure/100.0
//        binding.apply {
//            textMain.text = data.current.weather[0].main
//            textDescription.text = data.current.weather[0].description
//            textTemp.text = data.current.temp.toString()
////            textHumidity.text = data.main.humidity.toString()
////            textPressure.text = data.main.pressure.toString()
////            textTempMin.text = data.main.temp_min.toString()
////            textTempMax.text = data.main.temp_max.toString()
////            textFeelsLike.text = data.main.feels_like.toString()
////            textWind.text = data.wind.speed.toString()
//            textVisibility.text = visibility.toString()
////            textPressure.text = pressure.toString()
//        }
//    }

}
