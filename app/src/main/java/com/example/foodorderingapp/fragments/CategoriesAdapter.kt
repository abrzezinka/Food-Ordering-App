package com.example.foodorderingapp.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.R

class CategoriesAdapter(private val layoutManager: GridLayoutManager? = null): RecyclerView.Adapter<CategoriesAdapter.MyViewHolder>() {

    // TODO - change list type
    private var categoriesList = emptyList<Int>()

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val textViewCathegory: TextView
        val layout: ConstraintLayout

        init{
            textViewCathegory = itemView.findViewById(R.id.category_txt)
            layout = itemView.findViewById(R.id.categoriesAdapterLayout)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate
            (R.layout.categories_adapter, parent, false) as View)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.layout.setOnClickListener {
            TODO( "add navigation to elements from category")
        }
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }
}