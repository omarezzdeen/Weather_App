package com.example.weatherapp

import android.util.Log
import com.example.weatherapp.data.*
import com.example.weatherapp.util.Constants

object DataManager {
    private var _dataList : Weather? = null
    private var _dataListDaily = mutableListOf<Daily>()
    private var _dataListHourly = mutableListOf<Hourly>()

    val dataList : Weather?
        get() = _dataList

    val dataListDaily : List<Daily>
        get() = _dataListDaily

    val dataListHourly : List<Hourly>
        get() = _dataListHourly

    fun saveWeatherData(data: Weather) {
        _dataList = data
        Log.i(Constants.TAG_DATA_MANGER, "data saved: $_dataList")
    }

    fun saveDailyData(data: Daily) {
        _dataListDaily.add(data)
        Log.i(Constants.TAG_DATA_MANGER, "data saved: $_dataListDaily")
    }
    fun saveHourlyData(data: Hourly) {
        _dataListHourly.add(data)
        Log.i(Constants.TAG_DATA_MANGER, "data saved: $_dataListHourly")
    }

    fun transformationUnixTimestampForDate(data: Int, path: String): CharSequence? {
        val sdf = java.text.SimpleDateFormat(path)
        val date = java.util.Date(data.toLong() * 1000)
        return sdf.format(date)
    }
}
