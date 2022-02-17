package com.example.foodorderingapp.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapp.R
import com.example.foodorderingapp.databinding.FragmentHomePageBinding

class HomePage : Fragment() {

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding =  FragmentHomePageBinding.inflate(inflater, container, false)

        return binding.root
    }
    override fun onViewCreated(view:View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.home_to_menu).apply {
            setOnClickListener {
                view.findNavController().navigate(R.id.action_homePage_to_cathegoriesList)
            }
        }
        view.findViewById<Button>(R.id.home_to_order).apply {
            setOnClickListener {
                view.findNavController().navigate(R.id.action_homePage_to_deliveryOrTakeoutChoice)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}