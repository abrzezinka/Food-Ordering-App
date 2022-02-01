package com.example.foodorderingapp.fragments

import android.content.Context
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.R

class CategoriesAdapter(private val view: View,
                        private val viewModel: CategoryViewModel,
                        private val context: Context?,
                        private val arg: Bundle?)
    : RecyclerView.Adapter<CategoriesAdapter.category_list_holder>() {

    inner class category_list_holder(view: View) : RecyclerView.ViewHolder(view) {
        val category_txt: TextView = view.findViewById(R.id.category_txt)
        val category_image: ImageView = view.findViewById(R.id.category_image)
    }

    //private var categoriesList = emptyList<Int>()

    /*class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textViewCathegory: TextView
        val layout: ConstraintLayout

        init{
            textViewCathegory = itemView.findViewById(R.id.category_txt)
            layout = itemView.findViewById(R.id.categoriesAdapterLayout)
        }
    }*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): category_list_holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_adapter,parent,false)
        return category_list_holder(view)
    }

    override fun onBindViewHolder(holder: category_list_holder, position: Int) {
        holder.category_txt.text = viewModel.categories.value?.get(position)?.name//todo set name of category and image
        //holder.category_image = viewModel.categories.value?.get(position)?.image//get image

        holder.category_txt.setOnClickListener {
            val action = CategoriesListDirections.actionCathegoriesListToProductsList(arg?.get("isOrder") as Boolean)
            view.findNavController().navigate(action)
        }
        holder.category_image.setOnClickListener {
            val action = CategoriesListDirections.actionCathegoriesListToProductsList(arg?.get("isOrder") as Boolean)
            view.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return viewModel.categories.value?.size?:0
    }
}