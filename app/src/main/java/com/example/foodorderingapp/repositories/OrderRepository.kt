package com.example.foodorderingapp.repositories

import com.example.foodorderingapp.api.OrderService
import com.example.foodorderingapp.model.Order
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class OrderRepository(private val orderService: OrderService) {

    fun addOrder(order: Order){
        val call = orderService.addOrder(order).enqueue(
            object : Callback<Order>{
                override fun onFailure(call: Call<Order>, t: Throwable) {
                }
                override fun onResponse(call: Call<Order>, response: Response<Order>) {
                    response.body()
                }
            }
        )

    }
}