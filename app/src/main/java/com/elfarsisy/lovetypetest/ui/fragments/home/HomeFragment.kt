package com.elfarsisy.lovetypetest.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.elfarsisy.lovetypetest.R
import com.elfarsisy.lovetypetest.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding.startViewModel = viewModel
        binding.setLifecycleOwner(this)
        viewModel.navigateToQuickStart.observe(viewLifecycleOwner, Observer { isNavigate ->
            if (isNavigate) {
                //navigate
                val action = HomeFragmentDirections.actionHomeFragmentToQuickStartFragment()
                findNavController().navigate(action)

                viewModel.onNavigatToQuickTestComplete()
            }
        })

        viewModel.navigateToMentalTest.observe(viewLifecycleOwner, Observer { isNavigate ->
            if (isNavigate) {
//                //navigate
                val action = HomeFragmentDirections.actionHomeFragmentToMentalTestStartFragment()
                findNavController().navigate(action)

                viewModel.onNavigatToMentalTestComplete()
            }
        })

        viewModel.navigateToMoreTests.observe(viewLifecycleOwner, Observer { isNavigate ->
            if (isNavigate) {

                val action = HomeFragmentDirections.actionHomeFragmentToMoreTestFragment()
                findNavController().navigate(action)

                viewModel.onNavigatToMoreTestsComplete()
            }
        })

        viewModel.navigateToResult.observe(viewLifecycleOwner, Observer { isNavigate ->
            if (isNavigate) {
                //navigate
                // frist we will navigate to purechase
                val action = HomeFragmentDirections.actionHomeFragmentToInPurchaseFragment()
                findNavController().navigate(action)

                viewModel.onNavigatToResultComplet()
            }
        })


        return binding.root
    }

}
