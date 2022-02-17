package com.example.foodorderingapp.model

import com.google.gson.annotations.SerializedName

data class Person(
    @SerializedName("name") val name: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone_number") val phoneNumber: String
)
