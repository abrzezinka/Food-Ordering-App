package com.example.foodorderingapp.model

import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("city") val city: String,
    @SerializedName("street") val street: String,
    @SerializedName("building_number") val buildingNumber: Int,
    @SerializedName("flat_number") val flatNumber: Int,
    @SerializedName("zip_code") val zipCode: Int,
)
