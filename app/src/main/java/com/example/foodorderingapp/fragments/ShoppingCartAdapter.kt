package com.example.foodorderingapp.fragments

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.R
import com.example.foodorderingapp.model.Purchase
import com.squareup.picasso.Picasso

class ShoppingCartAdapter(): RecyclerView.Adapter<ShoppingCartAdapter.MyViewHolder>() {

    private var shoppingList = emptyList<Purchase>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var image: ImageView = itemView.findViewById(R.id.dishImage)
        var dishName: TextView = itemView.findViewById(R.id.dish_name)
        var quantity: TextView = itemView.findViewById(R.id.quantity_txt)
        var price: TextView = itemView.findViewById(R.id.productsPrice_txt)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_cart_adapter,
        parent, false) as View
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = shoppingList[position]
        Picasso.get().load(currentItem.product.image).into(holder.image)
        holder.dishName.text = currentItem.product.name
        holder.quantity.text = currentItem.quantity.toString()
        holder.price.text = String.format("%.2f",
            (currentItem.product.price * currentItem.quantity.toDouble())) + "$"

    }

    override fun getItemCount(): Int {
        return shoppingList.size
    }

    fun setData(list: List<Purchase>){
        this.shoppingList = list
        notifyDataSetChanged()
    }
}