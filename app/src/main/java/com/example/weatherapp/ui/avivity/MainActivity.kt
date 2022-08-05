package com.example.weatherapp.ui.avivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.DataManager
import com.example.weatherapp.data.HomeItem
import com.example.weatherapp.data.HomeItemType
import com.example.weatherapp.data.Weather
import com.example.weatherapp.network.Client
import com.example.weatherapp.ui.adapter.HomeAdapter

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val dataManager = DataManager

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
                val adapter = HomeAdapter(callBack())
                binding.recyclerViewHome.adapter = adapter
//                callBack(dataManager.dataList!!)
            }
        }
    }

    private fun callBack(): List<HomeItem<Any>> {
        val list = mutableListOf<HomeItem<Any>>()
        list.add(HomeItem(dataManager.dataList!!, HomeItemType.TYPE_HEADER))
        list.add(HomeItem("Today's weather", HomeItemType.TYPE_TITLE))
        list.add(HomeItem(dataManager.dataListHourly, HomeItemType.TYPE_HOURLY))
        list.add(HomeItem(dataManager.dataListDaily, HomeItemType.TYPE_DAILY))
        list.add(HomeItem("More Info", HomeItemType.TYPE_TITLE))
        list.add(HomeItem(dataManager.dataList!!, HomeItemType.TYPE_DETAILS))
        return list
    }

//    private fun callBack(data: Weather) {
//        val visibility = data.current.visibility / 1000
//        val pressure = data.current.pressure / 100.0
//        binding.apply {
//            textMain.text = data.current.weather[0].main
//            textDescription.text = data.current.weather[0].description
//            textTemp.text = data.current.temp.toInt().toString()
//            textHumidity.text = data.current.humidity.toString()
//            textPressure.text = data.current.pressure.toString()
////            textTempMin.text = data.current.temp_min.toInt().toString()
////            textTempMax.text = data.current.temp_max.toInt().toString()
//            textFeelsLike.text = data.current.feels_like.toString()
//            textWind.text = data.current.wind_speed.toString()
//            textSunrise.text = dataManager.transformationUnixTimestampForDate(data.current.sunrise, "h:mm a")
//            textSunset.text = dataManager.transformationUnixTimestampForDate(data.current.sunset,"h:mm a")
//            textVisibility.text = visibility.toString()
//            textPressure.text = pressure.toString()
//
//            recyclerView.adapter = WeatherAdapter(dataManager.dataListHourly)
//
//        }

//    }

}

