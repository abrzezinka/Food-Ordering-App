package com.example.foodorderingapp.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.R
import com.example.foodorderingapp.model.Category

class CategoriesAdapter : RecyclerView.Adapter<CategoriesAdapter.category_list_holder>() {

    private var _categoriesList = emptyList<Category>()
    private var _isOrder: Boolean = false

    inner class category_list_holder(view: View) : RecyclerView.ViewHolder(view) {
        val category_txt: TextView = view.findViewById(R.id.category_txt)
        val category_img: ImageView = view.findViewById(R.id.category_image)
        val adapterLayout: ConstraintLayout = view.findViewById(R.id.categoriesAdapterLayout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): category_list_holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_adapter,parent,false) as View
        return category_list_holder(view)
    }

    override fun onBindViewHolder(holder: category_list_holder, position: Int) {
        val currentItem = _categoriesList[position]
        holder.category_txt.text = currentItem.name

         holder.adapterLayout.setOnClickListener {
             val action = CategoriesListDirections.actionCathegoriesListToProductsList(isOrder = _isOrder, category = currentItem)
             holder.itemView.findNavController().navigate(action)
         }
    }

    override fun getItemCount(): Int {
        return _categoriesList.size
    }

    fun setData(categories: List<Category>, isOrder: Boolean = false){
        this._categoriesList = categories
        this._isOrder = isOrder
        notifyDataSetChanged()
    }
}