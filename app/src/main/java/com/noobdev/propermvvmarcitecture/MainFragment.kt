package com.noobdev.propermvvmarcitecture

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.noobdev.propermvvmarcitecture.databinding.FragmentMainBinding


class MainFragment : Fragment(R.layout.fragment_main) {

    private var binding: FragmentMainBinding?=null
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.bind(view)
        navController = findNavController()

        binding!!.xml.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_xmlFragment)
        }
        binding!!.compose.setOnClickListener {
            navController.navigate(R.id.action_mainFragment_to_composeFragment)
        }
    }




    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}