package com.example.foodorderingapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodorderingapp.api.RestaurantService
import com.example.foodorderingapp.api.RetrofitClient
import com.example.foodorderingapp.model.Restaurant
import com.example.foodorderingapp.repositories.RestaurantRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RestaurantViewModel: ViewModel(){
    var readAllData: MutableLiveData<List<Restaurant>>
    private val retroInstance = RetrofitClient.getRetroInstance()
    private val restaurantService: RestaurantService = retroInstance.create(RestaurantService::class.java)
    private val repository: RestaurantRepository

    init {
        readAllData = MutableLiveData()
        repository = RestaurantRepository(restaurantService)
    }

    fun getLiveDataObserver(): MutableLiveData<List<Restaurant>>{
        return readAllData
    }

    fun getRestaurantsDataCall(){
        val call = repository.getRestaurantsList()
        call.enqueue(object: Callback<List<Restaurant>>{
            override fun onFailure(call: Call<List<Restaurant>>, t: Throwable) {
                readAllData.postValue(null)
            }
            override fun onResponse(
                call: Call<List<Restaurant>>,
                response: Response<List<Restaurant>>
            ){
                readAllData.postValue(response.body())
            }
        })
    }

}