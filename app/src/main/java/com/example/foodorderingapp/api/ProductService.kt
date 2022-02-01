package com.example.foodorderingapp.api

import com.example.foodorderingapp.model.Product
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {

    // TODO ( add endpoint )
    @GET(value = "todo")
    fun getProductsList(): Call<List<Product>>


    @GET("endpoint/?")
    fun getProductsFromCategory(@Query("category__name")category: String): Call<List<Product>>
}