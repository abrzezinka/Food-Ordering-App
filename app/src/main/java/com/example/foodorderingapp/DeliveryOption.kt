package com.example.foodorderingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toolbar
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
        val toolbar = view.findViewById<Toolbar>(R.id.toolbar_delivery_option)

        toolbar.inflateMenu(R.menu.menu_back)
        toolbar.setOnMenuItemClickListener {
            if(it.itemId==R.id.back_button){
                view.findNavController().navigate(R.id.action_deliveryOption_to_deliveryOrTakeoutChoice)
            }
            true
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delivery_option, container, false)
    }


}
