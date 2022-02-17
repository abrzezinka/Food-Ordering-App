package com.example.foodorderingapp

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.viewmodel.RestaurantViewModel


class DeliveryOption : Fragment() {

    private lateinit var viewModel: RestaurantViewModel
    //private val layoutManager: LinearLayoutManager(requireCOntext())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_delivery_option, container, false)

        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_delivery_option, container, false)
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_back, menu)
        super.onCreateOptionsMenu(menu, inflater);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.back_button -> {
                view?.findNavController()?.navigate(R.id.action_deliveryOption_to_deliveryOrTakeoutChoice)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}
