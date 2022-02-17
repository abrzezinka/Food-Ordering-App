package com.example.foodorderingapp.model

import com.google.gson.annotations.SerializedName

data class Order(
    val type: String? = null,
    @SerializedName("restaurant") val restaurant: String? = null,
    @SerializedName("address") val address: Address? = null,
    @SerializedName("person") val personalData: Person? = null,
    @SerializedName("shopping_list") val shoppingList: List<Purchase>,
)