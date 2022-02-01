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

class ProductsListToBuyAdapter(private val view: View,
                          private val viewModel: ProductViewModel,
                          private val context: Context?,
                          private val arg: Bundle?)
    : RecyclerView.Adapter<ProductsListToBuyAdapter.product_list_to_buy_holder>(){

    //private var productsList = emptyList<Int>()

    //class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    //val desc_textViewProductsList: TextView
    //val imageViewProductsList: ImageView
    //val layout: ConstraintLayout

    //init{
    //    desc_textViewProductsList = itemView.findViewById(R.id.product_txt)
    //    imageViewProductsList = itemView.findViewById(R.id.product_image)
    //    layout = itemView.findViewById(R.id.productsListAdapterLayout)
    //}
    //}

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
        holder.product_txt.text = viewModel.products.value?.get(position)?.name//todo set name of category and image
        //holder.product_image = viewModel.products.value?.get(position)?.image//get image//todo getting images?
        holder.product_price.text = viewModel.products.value?.get(position)?.price

        holder.button_add.setOnClickListener{
            //todo adding item do cart
        }

    }

    override fun getItemCount(): Int {
        return viewModel.products.value?.size?:0
    }
}