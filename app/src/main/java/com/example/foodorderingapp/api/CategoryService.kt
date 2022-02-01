package com.example.foodorderingapp.api

import com.example.foodorderingapp.model.Category
import retrofit2.Call
import retrofit2.http.GET

interface CategoryService {

    @GET(value = "todo")
    fun getCategoriesList(): Call<List<Category>>
}