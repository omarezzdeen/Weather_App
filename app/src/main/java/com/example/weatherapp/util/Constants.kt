package com.example.weatherapp.util

object Constants {
    const val baseUrl = "https://api.openweathermap.org/data/2.5/onecall?&units=metric&exclude=minutely&appid=8c9a22ad31737b2f20be08e6f46f7998&lat=31.51667&lon=34.48333"
    const val baseUrlWeather = "https://api.openweathermap.org/data/2.5/weather?lat=31.51667&lon=34.48333&appid=8c9a22ad31737b2f20be08e6f46f7998&lang=en&units=metric"

    const val TAG = "OE_PROGRAMMER"
    const val TAG_DATA_MANGER = "DataManager"

    const val TYPE_DATE_HOURLY = "h aa"
    const val TYPE_DATE_DAILY = "EEEE"
    const val TYPE_DATE_DETAILS = "h:mm aa"
}
