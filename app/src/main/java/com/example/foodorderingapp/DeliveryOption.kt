package com.example.foodorderingapp

import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodorderingapp.viewmodel.RestaurantViewModel
import android.widget.LinearLayout
import android.widget.Toast

import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


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
    override fun onViewCreated(view:View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.button_save_data).apply {
            setOnClickListener {
                val name= view.findViewById<TextInputEditText>(R.id.name_et).text.toString().trim()
                val lastname=view.findViewById<TextInputEditText>(R.id.lastName_et).text.toString()
                val email= view.findViewById<TextInputEditText>(R.id.email_et).text.toString()
                val phone= view.findViewById<TextInputEditText>(R.id.phoneNumber_et).text.toString()
                val street= view.findViewById<TextInputEditText>(R.id.street_et).text.toString()
                val number_building= view.findViewById<TextInputEditText>(R.id.buildingNumber_et).text.toString()
                val zipcode= view.findViewById<TextInputEditText>(R.id.zipcode_et).text.toString()
                val city= view.findViewById<TextInputEditText>(R.id.city_et).text.toString()

                if(name.isEmpty()){
                    //view.findViewById<TextInputEditText>(R.id.name_et).error="Wpisz imię"
                    //view.findViewById<TextInputEditText>(R.id.name_et).requestFocus()
                    //return@setOnClickListener
                }
                else if(lastname.isEmpty()){
                    //view.findViewById<TextInputEditText>(R.id.lastName_et).error="Wpisz nazwisko"
                    //view.findViewById<TextInputEditText>(R.id.lastName_et).requestFocus()
                    //return@setOnClickListener
                }
                else if(email.isEmpty()){
                    //view.findViewById<TextInputEditText>(R.id.email_et).error="Wpisz email"
                    //view.findViewById<TextInputEditText>(R.id.email_et).requestFocus()
                    //return@setOnClickListener
                }
                else if(phone.isEmpty()){
                    //view.findViewById<TextInputEditText>(R.id.phoneNumber_et).error="Wpisz numer telefonu"
                    //view.findViewById<TextInputEditText>(R.id.phoneNumber_et).requestFocus()
                    //return@setOnClickListener
                }
                else if(street.isEmpty()){
                    //view.findViewById<TextInputEditText>(R.id.street_et).error="Wpisz ulicę"
                    //view.findViewById<TextInputEditText>(R.id.street_et).requestFocus()
                    //return@setOnClickListener
                }
                else if(number_building.isEmpty()){
                    //view.findViewById<TextInputEditText>(R.id.buildingNumber_et).error="Wpisz numer budynku"
                   // view.findViewById<TextInputEditText>(R.id.buildingNumber_et).requestFocus()
                    //return@setOnClickListener
                }
                else if(zipcode.isEmpty()){
                   // view.findViewById<TextInputEditText>(R.id.zipcode_et).error="Wpisz kod pocztowy"
                    //view.findViewById<TextInputEditText>(R.id.zipcode_et).requestFocus()
                    //return@setOnClickListener
                }
                else if(city.isEmpty()){
                    //view.findViewById<TextInputEditText>(R.id.city_et).error="Wpisz miasto"
                    //view.findViewById<TextInputEditText>(R.id.city_et).requestFocus()
                    //return@setOnClickListener
                }
                else{
                    view.findNavController().navigate(R.id.action_deliveryOption_to_cathegoriesList)
                }
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
                view?.findNavController()?.navigate(R.id.action_deliveryOption_to_deliveryOrTakeoutChoice)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}
