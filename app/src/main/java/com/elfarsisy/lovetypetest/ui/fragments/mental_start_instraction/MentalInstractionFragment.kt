package com.elfarsisy.lovetypetest.ui.fragments.mental_start_instraction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.elfarsisy.lovetypetest.R
import com.elfarsisy.lovetypetest.databinding.FragmentMentalInstractionBinding


class MentalInstractionFragment : Fragment() {



    private lateinit var binding: FragmentMentalInstractionBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mental_instraction, container, false)


        binding.setLifecycleOwner(this)
        binding.goToMentalTest.setOnClickListener { goToMentalTest() }

        return binding.root
    }

    private fun goToMentalTest() {
        // navigate to Menta Test Fragment
        val action = MentalInstractionFragmentDirections.actionMentalInstractionFragmentToMentalTestFragment()
        findNavController().navigate(action)
    }


}
