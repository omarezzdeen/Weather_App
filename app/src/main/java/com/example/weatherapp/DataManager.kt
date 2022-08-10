package com.example.weatherapp

import android.util.Log
import com.example.weatherapp.data.*
import com.example.weatherapp.data.model.Weathers
import com.example.weatherapp.util.Constants

class DataManager {
    private var _dataList : Weathers.WeatherModel? = null
    private var _dataListDaily = mutableListOf<Weathers.Daily>()
    private var _dataListHourly = mutableListOf<Weathers.Hourly>()

    val dataList : Weathers.WeatherModel?
        get() = _dataList

    val dataListDaily : List<Weathers.Daily>
        get() = _dataListDaily

    val dataListHourly : List<Weathers.Hourly>
        get() = _dataListHourly

    fun saveWeatherData(data: Weathers.WeatherModel) {
        _dataList = data
        Log.i(Constants.TAG_DATA_MANGER, "data saved: $_dataList")
    }

    fun saveDailyData(data: Weathers.Daily) {
        _dataListDaily.add(data)
        Log.i(Constants.TAG_DATA_MANGER, "data saved: $_dataListDaily")
    }
    fun saveHourlyData(data: Weathers.Hourly) {
        _dataListHourly.add(data)
        Log.i(Constants.TAG_DATA_MANGER, "data saved: $_dataListHourly")
    }


}
