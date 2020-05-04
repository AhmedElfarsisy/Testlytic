package com.elfarsisy.lovetypetest.ui.fragments.emotional_quick_test_results

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
import com.elfarsisy.lovetypetest.databinding.FragmentQuickTestResultsBinding


class QuickTestResultsFragment : Fragment() {
    private lateinit var binding: FragmentQuickTestResultsBinding
    private lateinit var viewModel: QuickResultViewModel
    private lateinit var viewModelFactory:QuickResultsViewModelFactory
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quick_test_results, container, false)

        viewModelFactory =
            QuickResultsViewModelFactory(QuickTestResultsFragmentArgs.fromBundle(arguments!!).quickTestDegree)
        viewModel = ViewModelProvider(this,viewModelFactory).get(QuickResultViewModel::class.java)
        binding.resultsViewModel = viewModel
        binding.setLifecycleOwner(this)
        viewModel.navigateToQuickStartResult.observe(viewLifecycleOwner, Observer { isNavigate ->
            if (isNavigate) {

                val action = QuickTestResultsFragmentDirections.actionQuickTestResultsFragmentToQuickTestDetailsFragment(viewModel.character.value.toString())
                findNavController().navigate(action)

                viewModel.onNavigatToQuickStartResultComplete()
            }
        })
        viewModel.navigateToHome.observe(viewLifecycleOwner, Observer { isNavigate ->
            if (isNavigate) {
                val action =
                    QuickTestResultsFragmentDirections.quickResultPopUpToHome()
                findNavController().navigate(action)
                viewModel.onNavigatToHomeComplete()
            }
        })
        return binding.root
    }

}
