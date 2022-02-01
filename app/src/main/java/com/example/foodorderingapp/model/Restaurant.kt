package com.example.foodorderingapp.model

data class Restaurant(
    val country__name: String,
    val state__name: String,
    val city: String,
    val address: Address,
    val code: Int
)
