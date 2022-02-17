package com.example.foodorderingapp

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.databinding.FragmentTakeawayOptionBinding
import com.example.foodorderingapp.fragments.CategoriesAdapter
import com.example.foodorderingapp.fragments.RestaurantsListAdapter
import com.example.foodorderingapp.viewmodel.RestaurantViewModel

class TakeawayOption : Fragment() {

    private lateinit var viewModel: RestaurantViewModel
    private var _binding: FragmentTakeawayOptionBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentTakeawayOptionBinding.inflate(inflater, container, false)

        val restaurantsView = binding.restaurantsRecyclerView
        restaurantsView.layoutManager = LinearLayoutManager(requireContext())
        val adapter =  RestaurantsListAdapter()
        restaurantsView.adapter = adapter

        viewModel = ViewModelProvider(this)[RestaurantViewModel::class.java]

        viewModel.getLiveDataObserver().observe(viewLifecycleOwner, Observer {
            if(it != null){
                adapter.setData(it)
                adapter.notifyDataSetChanged()
            } else{
                Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.getRestaurantsDataCall()

        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_back, menu)
        super.onCreateOptionsMenu(menu, inflater);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.back_button -> {
                view?.findNavController()?.navigate(R.id.action_takeawayOption_to_deliveryOrTakeoutChoice)
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