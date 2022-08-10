package com.example.weatherapp.util

object Constants {

    const val PROTOCOL = "https"
    const val HOST = "api.openweathermap.org"
    const val KEY = "8c9a22ad31737b2f20be08e6f46f7998"

    const val LAT = "lat"
    const val LON = "lon"
    const val APPID = "appid"
    const val UNITS = "units"

    const val URL_IMAGE = "https://openweathermap.org/img/w/"
    const val IMAGE_EXTENSION = ".png"



    const val baseUrl = "https://api.openweathermap.org/data/2.5/onecall?&units=metric&exclude=minutely&appid=8c9a22ad31737b2f20be08e6f46f7998&lat=31.51667&lon=34.48333"
    const val baseUrlWeather = "https://api.openweathermap.org/data/2.5/weather?lat=31.51667&lon=34.48333&appid=8c9a22ad31737b2f20be08e6f46f7998&lang=en&units=metric"

    const val TAG = "OE_PROGRAMMER"
    const val TAG_DATA_MANGER = "DataManager"

    const val TYPE_DATE_HOURLY = "h aa"
    const val TYPE_DATE_DAILY = "EEEE"
    const val TYPE_DATE_DETAILS = "h:mm aa"
}
