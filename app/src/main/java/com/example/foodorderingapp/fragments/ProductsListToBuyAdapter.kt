package com.example.foodorderingapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.R
import com.example.foodorderingapp.model.Order
import com.example.foodorderingapp.model.Product

class ProductsListToBuyAdapter() : RecyclerView.Adapter<ProductsListToBuyAdapter.product_list_to_buy_holder>(){

    private var productsList = emptyList<Product>()

    inner class product_list_to_buy_holder(view: View) : RecyclerView.ViewHolder(view) {
        val product_txt: TextView = view.findViewById(R.id.product_txt)
        val product_image: ImageView = view.findViewById(R.id.product_image)
        val product_price: TextView = view.findViewById(R.id.price_txt)
        val button_add: Button = view.findViewById(R.id.add_to_buy)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): product_list_to_buy_holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.products_list_to_buy_adapter,parent,false)
        return product_list_to_buy_holder(view)
    }

    override fun onBindViewHolder(holder: product_list_to_buy_holder, position: Int) {
        holder.product_txt.text = productsList[position].name
        //holder.product_image = viewModel.products.value?.get(position)?.image//get image//todo getting images?
        holder.product_price.text = productsList[position].prize.toString()

        //todo add viewmodel to order
        holder.button_add.setOnClickListener{
            Order.addProduct(productsList[position])
        }

    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    fun setData(products: List<Product>){
        this.productsList = products
        notifyDataSetChanged()
    }
}