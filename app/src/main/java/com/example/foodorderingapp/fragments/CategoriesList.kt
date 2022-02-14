package com.example.foodorderingapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodorderingapp.R
import com.example.foodorderingapp.databinding.FragmentCathegoriesListBinding
import com.example.foodorderingapp.viewmodel.CategoryViewModel

import android.view.Menu
import android.view.MenuItem
import android.widget.Toast


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


        viewModel = ViewModelProvider(this)[CategoryViewModel::class.java]

        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        viewModel.readAllData.observe(viewLifecycleOwner, Observer{
                            category -> adapter.setData(category, _isOrder)})

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_back, menu)
        super.onCreateOptionsMenu(menu, inflater);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val _isOrder = args.isAnOrder
        return when (item.itemId) {
            R.id.back_button -> {
                if(_isOrder==true) view?.findNavController()?.navigate(R.id.action_cathegoriesList_to_deliveryOrTakeoutChoice)
                else view?.findNavController()?.navigate(R.id.action_cathegoriesList_to_homePage)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}