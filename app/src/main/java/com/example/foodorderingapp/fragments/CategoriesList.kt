package com.example.foodorderingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodorderingapp.databinding.FragmentCathegoriesListBinding
import com.example.foodorderingapp.fragments.CategoriesAdapter


class CategoriesList : Fragment() {

    private var layoutManager: GridLayoutManager? = null
    private var _binding: FragmentCathegoriesListBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentCathegoriesListBinding.inflate(inflater, container, false)
        val cathegoriesView = binding.cathegoriesRecyclerView
        layoutManager = GridLayoutManager(activity, 2)
        binding.cathegoriesRecyclerView.layoutManager = layoutManager
        cathegoriesView.adapter = CategoriesAdapter(layoutManager)


        return binding.root
    }

}