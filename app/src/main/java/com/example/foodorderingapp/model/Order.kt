package com.example.foodorderingapp.model

object Order {
    var shoppingCard: MutableList<Purchase> = mutableListOf()
        private set



    fun addProduct(product: Product){
        for (purchase in shoppingCard){
            if(product.name == purchase.product.name){
                purchase.quantity += 1
                break
            }
        }
        shoppingCard.add(Purchase(product))
    }

    fun removeProduct(product: Product){
        for (purchase in shoppingCard){
            if(product.name == purchase.product.name){
                if(purchase.quantity >1){
                    purchase.quantity -= 1
                }
                else{
                    shoppingCard.remove(purchase)
                }
                break
            }
        }
    }

}