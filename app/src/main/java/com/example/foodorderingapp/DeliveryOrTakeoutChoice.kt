package com.example.foodorderingapp

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController

class DeliveryOrTakeoutChoice : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_delivery_or_takeout_choice, container, false)

        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_delivery_or_takeout_choice, container, false)
    }
    override fun onViewCreated(view:View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button_to_delivery).apply {
            setOnClickListener {
                view.findNavController().navigate(R.id.action_deliveryOrTakeoutChoice_to_deliveryOption)
            }
        }
        view.findViewById<Button>(R.id.button_to_takeaway).apply {
            setOnClickListener {
                view.findNavController().navigate(R.id.action_deliveryOrTakeoutChoice_to_takeawayOption)
            }
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_back, menu)
        super.onCreateOptionsMenu(menu, inflater);
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.back_button -> {
                view?.findNavController()?.navigate(R.id.action_deliveryOrTakeoutChoice_to_homePage)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}