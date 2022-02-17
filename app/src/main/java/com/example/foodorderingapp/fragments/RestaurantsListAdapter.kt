package com.example.foodorderingapp.fragments

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.R
import com.example.foodorderingapp.TakeawayOptionDirections
import com.example.foodorderingapp.model.Restaurant
import com.example.foodorderingapp.model.ShoppingCard

class RestaurantsListAdapter(): RecyclerView.Adapter<RestaurantsListAdapter.MyViewHolder>() {

    private var restaurantsList = emptyList<Restaurant>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var cityName: TextView = itemView.findViewById(R.id.city_txt)
        var streetName: TextView = itemView.findViewById(R.id.street_txt)
        var code: TextView = itemView.findViewById(R.id.code_txt)

        val adapterLayout: ConstraintLayout = itemView.findViewById(R.id.restaurantListAdapterLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurants_list_adapter,
            parent, false) as View
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = restaurantsList[position]
        holder.cityName.text = currentItem.city
        holder.streetName.text = currentItem.address
        holder.code.text = currentItem.code

        holder.adapterLayout.setOnClickListener {
            val action = TakeawayOptionDirections.actionTakeawayOptionToCathegoriesList(isAnOrder = true)
            ShoppingCard.addRestaurant(currentItem)
            holder.itemView.findNavController().navigate(action)
        }

    }

    override fun getItemCount(): Int {
        return restaurantsList.size
    }

    fun setData(restaurants: List<Restaurant>){
        this.restaurantsList = restaurants
        notifyDataSetChanged()
    }
}