package com.example.foodorderingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.R
import com.example.foodorderingapp.databinding.FragmentCathegoriesListBinding
import com.example.foodorderingapp.databinding.FragmentProductsListBinding

class ProductsList : Fragment() {

    private lateinit var viewModel:ProductViewModel

    //private var layoutManager: GridLayoutManager? = null
    //private var _binding: FragmentProductsListBinding? = null
    //private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //_binding =  FragmentProductsListBinding.inflate(inflater, container, false)
       //val productsView = binding.productsRecyclerView
        //layoutManager = GridLayoutManager(activity, 2)
        //binding.productsRecyclerView.layoutManager = layoutManager
        //productsView.adapter = ProductsListAdapter(layoutManager)
        val view = inflater.inflate(R.layout.fragment_products_list, container, false)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_products)

        toolbar.inflateMenu(R.menu.menu_back)
        toolbar.setOnMenuItemClickListener {
            if(it.itemId==R.id.back_button){
                view.findNavController().navigate(R.id.action_productsList_to_cathegoriesList)
            }
            true
        }
        return inflater.inflate(R.layout.fragment_products_list,container,false)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ProductViewModel((requireNotNull(this.activity).application))

        //products-> List<Product> in viewmodel

        val product_adapter = ProductsListAdapter(view, viewModel, this.context, arguments)
        if(arguments?.get("isOrder") as Boolean){
            val product_adapter = ProductsListToBuyAdapter(view, viewModel, this.context, arguments)
        }

        viewModel.products.observe(viewLifecycleOwner) {
            product_adapter.notifyDataSetChanged()
        }

        val layoutManager = LinearLayoutManager(view.context)
        view.findViewById<RecyclerView>(R.id.productsRecyclerView).let {
            it.adapter = product_adapter
            it.layoutManager = layoutManager
        }

    //override fun onCreateView(
    //    inflater: LayoutInflater, container: ViewGroup?,
    //    savedInstanceState: Bundle?
    //): View? {
        // Inflate the layout for this fragment
    //    return inflater.inflate(R.layout.fragment_products_list, container, false)
    //}

    /*companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProductsList.
         */

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProductsList().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/
}