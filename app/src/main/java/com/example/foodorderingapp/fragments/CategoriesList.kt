package com.example.foodorderingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodorderingapp.R
import com.example.foodorderingapp.databinding.FragmentCathegoriesListBinding
import com.example.foodorderingapp.viewmodel.CategoryViewModel


class CategoriesList : Fragment() {

    private val args by navArgs<CategoriesListArgs>()
    private lateinit var viewModel: CategoryViewModel
    private var layoutManager: GridLayoutManager? = null
    private var _binding: FragmentCathegoriesListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentCathegoriesListBinding.inflate(inflater, container, false)

        val _isOrder = args.isAnOrder
        val view = inflater.inflate(R.layout.fragment_cathegories_list, container, false)

        val categoriesView = binding.cathegoriesRecyclerView
        val adapter = CategoriesAdapter()
        layoutManager = GridLayoutManager(activity, 2)
        categoriesView.layoutManager = layoutManager
        categoriesView.adapter = adapter

        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_categories)

        viewModel = ViewModelProvider(this)[CategoryViewModel::class.java]

        //adding toolbar


        toolbar.inflateMenu(R.menu.menu_back)
        toolbar.setOnMenuItemClickListener {
            if(it.itemId==R.id.back_button){
                //todo back to delivery or takeaway
                view.findNavController().navigate(R.id.action_cathegoriesList_to_deliveryOption)
            }
            true
        }

        viewModel.readAllData.observe(viewLifecycleOwner, Observer{
                            category -> adapter.setData(category, _isOrder)})

        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}