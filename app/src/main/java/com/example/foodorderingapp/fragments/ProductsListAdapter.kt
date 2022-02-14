package com.example.foodorderingapp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.R
import com.example.foodorderingapp.model.Product

class ProductsListAdapter() : RecyclerView.Adapter<ProductsListAdapter.product_list_holder>(){

    private var productsList = emptyList<Product>()

    inner class product_list_holder(view: View) : RecyclerView.ViewHolder(view) {
        val product_txt: TextView = view.findViewById(R.id.product_txt)
        val product_image: ImageView = view.findViewById(R.id.product_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): product_list_holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.products_list_adapter,parent,false)
        return product_list_holder(view)
    }

   override fun onBindViewHolder(holder: product_list_holder, position: Int) {
       val currentItem = productsList[position]
       holder.product_txt.text = currentItem.name //todo set name of category and image
        //holder.product_image = viewModel.products.value?.get(position)?.image//get image//todo getting images?
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    fun setData(products: List<Product>){
        this.productsList = products
        notifyDataSetChanged()
    }
}
