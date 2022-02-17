package com.example.foodorderingapp.viewmodel

import androidx.lifecycle.ViewModel
import com.example.foodorderingapp.api.CategoryService
import com.example.foodorderingapp.api.OrderService
import com.example.foodorderingapp.api.RetrofitClient
import com.example.foodorderingapp.model.Order
import com.example.foodorderingapp.model.ShoppingCard
import com.example.foodorderingapp.repositories.CategoryRepository
import com.example.foodorderingapp.repositories.OrderRepository
import retrofit2.Retrofit
import retrofit2.create

class OrderViewModel: ViewModel() {

    private val retroInstance: Retrofit
    private val orderService: OrderService
    private val repository: OrderRepository

    init {
        retroInstance = RetrofitClient.getRetroInstance()
        orderService = retroInstance.create(OrderService::class.java)
        repository = OrderRepository(orderService)
    }

    fun addOrder(order: Order){
        repository.addOrder(order)
    }
}