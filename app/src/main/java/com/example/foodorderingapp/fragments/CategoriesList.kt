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
import com.example.foodorderingapp.fragments.CategoriesAdapter


class CategoriesList : Fragment() {

    private lateinit var viewModel: CategoryViewModel

    //private var layoutManager: GridLayoutManager? = null
    //private var _binding: FragmentCathegoriesListBinding? = null
    //private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        //_binding =  FragmentCathegoriesListBinding.inflate(inflater, container, false)
        //val cathegoriesView = binding.cathegoriesRecyclerView
        //layoutManager = GridLayoutManager(activity, 2)
        //binding.cathegoriesRecyclerView.layoutManager = layoutManager
        //cathegoriesView.adapter = CategoriesAdapter(layoutManager)

        //adding toolbar
        val view = inflater.inflate(R.layout.fragment_cathegories_list, container, false)
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_categories)

        toolbar.inflateMenu(R.menu.menu_back)
        toolbar.setOnMenuItemClickListener {
            if(it.itemId==R.id.back_button){
                //todo back to delivery or takeaway
                view.findNavController().navigate(R.id.action_cathegoriesList_to_deliveryOption)
            }
            true
        }

        return inflater.inflate(R.layout.fragment_cathegories_list,container,false)
    }
    /*override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)
    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //categories-> List<Category> in viewmodel
        viewModel = CategoryViewModel((requireNotNull(this.activity).application))

        val category_adapter = CategoriesAdapter(view, viewModel, this.context, arguments)

        viewModel.categories.observe(viewLifecycleOwner) {
            category_adapter.notifyDataSetChanged()
        }

        val layoutManager = LinearLayoutManager(view.context)
        view.findViewById<RecyclerView>(R.id.cathegoriesRecyclerView).let {
            it.adapter = category_adapter
            it.layoutManager = layoutManager
        }
    }
}