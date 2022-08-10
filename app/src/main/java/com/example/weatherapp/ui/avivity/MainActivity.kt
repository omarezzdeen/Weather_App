package com.example.weatherapp.ui.avivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.DataManager
import com.example.weatherapp.data.HomeItem
import com.example.weatherapp.data.enums.HomeItemType
import com.example.weatherapp.data.model.State
import com.example.weatherapp.data.model.Weathers
import com.example.weatherapp.network.Client
import com.example.weatherapp.ui.adapter.HomeAdapter
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private val dataManager = DataManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getWeather()
    }

    private fun getWeather(){
        val observable = Observable.create { emitter ->
            emitter.onNext(State.Loading)
            emitter.onNext(Client.getWeatherData())
        }
        observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe ({ response ->
            when(response) {
                is State.Success -> setup(response.data)
                is State.Error -> Toast.makeText(this, response.message, Toast.LENGTH_SHORT).show()
                State.Loading -> {}
            }
        },{
            Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
        })
    }


    private fun setup(weather: Weathers.WeatherModel?) {
                val adapter = HomeAdapter(callBack(weather!!))
                binding.recyclerViewHome.adapter = adapter
    }

    private fun callBack(weather: Weathers.WeatherModel): List<HomeItem<Any>> {
        val list = mutableListOf<HomeItem<Any>>()
        list.add(HomeItem(weather.current!!, HomeItemType.TYPE_HEADER))
        list.add(HomeItem("Today's weather", HomeItemType.TYPE_TITLE))
        list.add(HomeItem(weather.hourly!!, HomeItemType.TYPE_HOURLY))
        list.add(HomeItem(weather.daily!!, HomeItemType.TYPE_DAILY))
        list.add(HomeItem("More Info", HomeItemType.TYPE_TITLE))
        list.add(HomeItem(weather.current, HomeItemType.TYPE_DETAILS))
        return list
    }

}

