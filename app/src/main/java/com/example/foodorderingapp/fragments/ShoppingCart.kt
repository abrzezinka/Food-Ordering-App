package com.example.foodorderingapp.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.databinding.FragmentShoppingCartBinding
import com.example.foodorderingapp.model.Order
import com.example.foodorderingapp.model.ShoppingCard
import com.example.foodorderingapp.viewmodel.OrderViewModel

class ShoppingCart : Fragment() {

    private var _binding: FragmentShoppingCartBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: OrderViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        viewModel = ViewModelProvider(this)[OrderViewModel::class.java]
        _binding = FragmentShoppingCartBinding.inflate(inflater, container, false)
        val cartView = binding.cartRecyclerView
        cartView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = ShoppingCartAdapter()
        cartView.adapter = adapter

        Log.i("KOSZYK", ShoppingCard.shoppingList.toString())
        adapter.setData(ShoppingCard.shoppingList)


        binding.sumTxt.text = String.format("%.2f", ShoppingCard.getFinalPrice()) + "$"
        val order = Order(
            "delivery",
            restaurant = ShoppingCard.getRestaurant()!!.code,
            shoppingList = ShoppingCard.shoppingList
            )

        binding.orderBtn.setOnClickListener{
            viewModel.addOrder(order)
        }

        return binding.root
    }

}