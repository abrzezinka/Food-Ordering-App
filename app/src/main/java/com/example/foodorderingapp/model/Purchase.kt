package com.example.foodorderingapp.model

class Purchase(var prod: Product, private var quant: Int = 1) {
    val product: Product = prod
    var quantity: Int = quant

}