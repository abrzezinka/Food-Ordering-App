package com.example.foodorderingapp.model

import android.util.Log

object ShoppingCard {
    var shoppingList: MutableList<Purchase> = mutableListOf()
        private set

    private var type: String? = null
    private var _address: Address? = null
    private var _person: Person? = null
    private var _restaurant: Restaurant? = null

    fun addAddress(address: Address){
        _address = address
    }

    fun getAddress(): Address? {
        return _address
    }

    fun addPersonalData(person: Person){
        _person = person
    }

    fun getPersonalData(): Person? {
        return _person
    }

    fun addRestaurant(restaurant: Restaurant){
        _restaurant = restaurant
    }

    fun getRestaurant(): Restaurant?{
        return _restaurant
    }

    fun addProduct(product: Product){
        for (purchase in shoppingList){
            if (purchase.prod.name == product.name){
                purchase.quantity += 1
                return
            }
        }
        shoppingList.add(Purchase(product))
    }

    fun removeProduct(product: Product){
        for (purchase in shoppingList){
            if(product.name == purchase.product.name){
                if(purchase.quantity >1){
                    purchase.quantity -= 1
                }
                else{
                    shoppingList.remove(purchase)
                }
                break
            }
        }
    }

    fun getFinalPrice(): Double {
        var sum: Double = 0.0
        for (purchase in shoppingList){
            sum += purchase.product.price * purchase.quantity
        }
        return sum
    }

}