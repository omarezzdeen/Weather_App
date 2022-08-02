package com.example.weatherapp

import android.util.Log
import com.example.weatherapp.data.*

class DataManager {
    private var _dataList : Weather? = null

    val dataList : Weather?
        get() = _dataList

    fun saveWeatherData(data: Weather) {
        _dataList = data
        Log.i(TAG, "data saved: $_dataList")
    }
    companion object {
        val TAG = "DataManager"
    }
}
