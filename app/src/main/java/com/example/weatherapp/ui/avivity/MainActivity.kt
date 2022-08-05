package com.example.weatherapp.ui.avivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.DataManager
import com.example.weatherapp.data.HomeItem
import com.example.weatherapp.data.enums.HomeItemType
import com.example.weatherapp.network.Client
import com.example.weatherapp.ui.adapter.HomeAdapter

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
                val adapter = HomeAdapter(callBack())
                binding.recyclerViewHome.adapter = adapter
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

}

