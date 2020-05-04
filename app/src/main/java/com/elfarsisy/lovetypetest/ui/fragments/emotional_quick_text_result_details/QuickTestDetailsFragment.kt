package com.elfarsisy.lovetypetest.ui.fragments.emotional_quick_text_result_details

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
import com.elfarsisy.lovetypetest.databinding.FragmentQuickTestDetailsBinding

class QuickTestDetailsFragment : Fragment() {

    private lateinit var binding: FragmentQuickTestDetailsBinding
    private lateinit var viewModelFactory: QuickTestDetailsFactory
    private lateinit var viewModel: QuickTestDetailsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_quick_test_details,
            container,
            false
        )
        viewModelFactory =
            QuickTestDetailsFactory(QuickTestDetailsFragmentArgs.fromBundle(arguments!!).character.toString())
        viewModel =
            ViewModelProvider(this, viewModelFactory).get(QuickTestDetailsViewModel::class.java)
        binding.quickTestDetails = viewModel
        binding.setLifecycleOwner(this)
        viewModel.navigateToHome.observe(viewLifecycleOwner, Observer { isNavigate ->
            if (isNavigate) {

                val action =
                    QuickTestDetailsFragmentDirections.detailsPopUpToHome()
                findNavController().navigate(action)
                viewModel.onNavigatToHomeComplete()
            }
        })
        return binding.root
    }

}
