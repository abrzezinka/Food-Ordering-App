package com.example.foodorderingapp.fragments

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

class RestaurantsListAdapter(): RecyclerView.Adapter<RestaurantsListAdapter.MyViewHolder>() {

    private var restaurantsList = emptyList<Restaurant>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.restaurant_txt)
        val adapterLayout: ConstraintLayout = itemView.findViewById(R.id.restaurantListAdapterLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.restaurants_list_adapter,
            parent, false) as View
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = restaurantsList[position]
        holder.adapterLayout.setOnClickListener {
            val action = TakeawayOptionDirections.actionTakeawayOptionToCathegoriesList(true)
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