package com.example.foodorderingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderingapp.api.RestaurantService
import com.example.foodorderingapp.model.Restaurant
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantViewModel: ViewModel(), KoinComponent {
    var readAllData: MutableLiveData<List<Restaurant>>
    val service: RestaurantService by inject()

    init {
        readAllData = MutableLiveData()
    }

    fun getLiveDataObserver(): MutableLiveData<List<Restaurant>>{
        return readAllData
    }

    fun getRestaurantsDataCall(){
        val call = service.getRestaurantsList()
        call.enqueue(object: Callback<List<Restaurant>>{
            override fun onFailure(call: Call<List<Restaurant>>, t: Throwable) {
                readAllData.postValue(null)
            }
            override fun onResponse(
                call: Call<List<Restaurant>>,
                response: Response<List<Restaurant>>
            ) {
                readAllData.postValue(response.body())
            }
        })
    }

}