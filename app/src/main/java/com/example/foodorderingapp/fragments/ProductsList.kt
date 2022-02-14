package com.example.foodorderingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.R
import com.example.foodorderingapp.databinding.FragmentCathegoriesListBinding
import com.example.foodorderingapp.databinding.FragmentProductsListBinding
import com.example.foodorderingapp.viewmodel.ProductViewModel

class ProductsList : Fragment() {

    private val args by navArgs<ProductsListArgs>()
    private lateinit var viewModel: ProductViewModel
    private var layoutManager: GridLayoutManager? = null
    private var _binding: FragmentProductsListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding =  FragmentProductsListBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this)[ProductViewModel::class.java]

        val _isOrder = args.isOrder
        val productsView = binding.productsRecyclerView
        layoutManager = GridLayoutManager(activity, 2)
        productsView.layoutManager = layoutManager

        val view = inflater.inflate(R.layout.fragment_products_list, container, false)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_products)

        toolbar.inflateMenu(R.menu.menu_back)
        toolbar.setOnMenuItemClickListener {
            if(it.itemId==R.id.back_button){
                view.findNavController().navigate(R.id.action_productsList_to_cathegoriesList)
            }
            true
        }

        when(_isOrder){
            true -> {
                val adapter = ProductsListToBuyAdapter()
                productsView.adapter = adapter
                viewModel.readAllData.observe(viewLifecycleOwner, Observer {
                    product -> adapter.setData(product)
                })
            }

            false -> {
                val adapter = ProductsListAdapter()
                productsView.adapter = adapter
                viewModel.readAllData.observe(viewLifecycleOwner, Observer {
                        product -> adapter.setData(product)
                })
            }
        }

        return binding.root
    }
}