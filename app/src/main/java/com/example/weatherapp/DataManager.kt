package com.example.weatherapp

import android.util.Log
import com.example.weatherapp.my_data.ClassItem
import com.example.weatherapp.my_data.Daily
import com.example.weatherapp.my_data.MyWeather
import com.example.weatherapp.my_data.Weather
import com.example.weatherapp.util.Constants

class DataManager {
    private var _dataList : MyWeather? = null

    val dataList : MyWeather?
        get() = _dataList

    fun saveWeatherData(data: MyWeather) {
        _dataList = data
        Log.i(Constants.TAG_CLIENT, "data saved: $_dataList")
    }

    var dataDaily  = mutableListOf<List<Daily>>()

//    val _dataDailyList : List<Daily>
//        get() = _dataDailyList

    fun saveWeatherDailyData(data: List<Daily>) {
        dataDaily.add(data)
        Log.i(Constants.TAG_CLIENT, "data saved: $dataDaily")
    }
}
