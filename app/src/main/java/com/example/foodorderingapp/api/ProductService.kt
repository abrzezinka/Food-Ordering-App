package com.example.foodorderingapp.api

import com.example.foodorderingapp.model.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET(value = "api/dishes")
    fun getProductsList(): Call<List<Product>>

    @GET("api/dishes/?")
    fun getProductsFromCategory(@Query("category")category: String): Call<List<Product>>
}