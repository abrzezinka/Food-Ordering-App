package com.example.foodorderingapp.repositories

import androidx.lifecycle.LiveData
import com.example.foodorderingapp.api.CategoryService
import com.example.foodorderingapp.api.ProductService
import com.example.foodorderingapp.model.Category
import retrofit2.Call

class CategoryRepository(private val categoryService: CategoryService) {

    fun getCategoriesList(): Call<List<Category>> {
        return categoryService.getCategoriesList()
    }
}