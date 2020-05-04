package com.elfarsisy.lovetypetest.ui.fragments.mental_start

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.elfarsisy.lovetypetest.R
import com.elfarsisy.lovetypetest.databinding.FragmentMentalTestStartBinding

/**
 * A simple [Fragment] subclass.
 */
class MentalTestStartFragment : Fragment() {

    private lateinit var binding: FragmentMentalTestStartBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_mental_test_start, container, false)
        binding.setLifecycleOwner(this)
        binding.startInstractionFragment.setOnClickListener {
            goToInstractionFragment()
        }
        binding.closeBrainStart.setOnClickListener {
            navigateToPOPStart()
        }

        return binding.root
    }

    private fun navigateToPOPStart() {
// navigate to direction
        val action =MentalTestStartFragmentDirections.popUpToHomeFragment()
        findNavController().navigate(action)
    }

    private fun goToInstractionFragment() {
        val action = MentalTestStartFragmentDirections.actionMentalTestStartFragmentToMentalInstractionFragment()
        findNavController().navigate(action)
    }

}
