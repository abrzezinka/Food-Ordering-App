package com.example.foodorderingapp.api

import com.example.foodorderingapp.model.Order
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface OrderService {

    @Headers("Content-Type: application/json")
    @POST(value = "api/order-create/")
    fun addOrder(@Body orderData: Order): Call<Order>
}