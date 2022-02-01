package com.example.foodorderingapp.api

import org.koin.dsl.module
import retrofit2.Retrofit

internal val apiService = module{
    single<ProductService>{get<Retrofit>().create(ProductService::class.java)}
    single<CategoryService>{get<Retrofit>().create(CategoryService::class.java)}
    single<RestaurantService>{get<Retrofit>().create(RestaurantService::class.java)}
}