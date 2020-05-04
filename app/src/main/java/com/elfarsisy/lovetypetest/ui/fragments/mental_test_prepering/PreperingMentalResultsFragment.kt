package com.elfarsisy.lovetypetest.ui.fragments.mental_test_prepering

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.elfarsisy.lovetypetest.R
import com.elfarsisy.lovetypetest.databinding.FragmentPreperingMentalResultsBinding

class PreperingMentalResultsFragment : Fragment() {
    private lateinit var binding: FragmentPreperingMentalResultsBinding
    private lateinit var viewModelFactory: PreperingResultFactory
    private lateinit var viewModel: PreperingResultsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_prepering_mental_results,
            container,
            false
        )

        val answersList = PreperingMentalResultsFragmentArgs.fromBundle(arguments!!).answersList
        viewModelFactory =
            PreperingResultFactory(answersList)
        viewModel =
            ViewModelProvider(this, viewModelFactory).get(PreperingResultsViewModel::class.java)
        binding.preperingResult = viewModel
        binding.setLifecycleOwner(this)

        viewModel.navigateToMentalResult.observe(viewLifecycleOwner, Observer { isNavigate ->
            if (isNavigate) {
                val action =
                    PreperingMentalResultsFragmentDirections.actionPreperingMentalResultsFragmentToMentalResultFragment(
                        viewModel.mentalDegree
                    )
                findNavController().navigate(action)
                viewModel.completeNavigateToMentalResult()
            }
        })

        return binding.root
    }

}
