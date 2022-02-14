package com.example.foodorderingapp.repositories

import com.example.foodorderingapp.api.RestaurantService
import com.example.foodorderingapp.model.Restaurant
import retrofit2.Call

class RestaurantRepository(private val restaurantService: RestaurantService) {

    fun getRestaurantsList(): Call<List<Restaurant>> {
        return restaurantService.getRestaurantsList()
    }
}