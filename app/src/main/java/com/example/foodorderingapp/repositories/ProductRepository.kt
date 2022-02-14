package com.example.foodorderingapp.repositories

import com.example.foodorderingapp.api.ProductService
import com.example.foodorderingapp.model.Product
import retrofit2.Call

class ProductRepository(private val productService: ProductService){

    fun getProductsList(): Call<List<Product>> {
        return productService.getProductsList()
    }

    fun getProductsFromCategory(category: String): Call<List<Product>> {
        return productService.getProductsFromCategory(category)
    }
}