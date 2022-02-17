package com.example.foodorderingapp.api


import com.example.foodorderingapp.model.Restaurant
import retrofit2.Call
import retrofit2.http.GET

interface RestaurantService {

    @GET("api/resturants")
    fun getRestaurantsList(): Call<List<Restaurant>>
}