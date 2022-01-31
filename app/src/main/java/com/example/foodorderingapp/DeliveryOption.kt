package com.example.foodorderingapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toolbar
import androidx.navigation.findNavController


class DeliveryOption : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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

    override fun onViewCreated(view:View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button_save_data).apply {
            setOnClickListener {
                view.findNavController().navigate(R.id.action_deliveryOption_to_cathegoriesList)
            }
        }
    }
}