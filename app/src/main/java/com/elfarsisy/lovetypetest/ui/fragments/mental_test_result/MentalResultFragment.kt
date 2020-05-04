package com.elfarsisy.lovetypetest.ui.fragments.mental_test_result

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
import com.elfarsisy.lovetypetest.databinding.FragmentMentalResultBinding
import com.elfarsisy.lovetypetest.ui.fragments.mentalresult.MetalResultFactory

class MentalResultFragment : Fragment() {

    private lateinit var binding: FragmentMentalResultBinding
    private lateinit var viewModelFactory: MetalResultFactory
    private lateinit var viewModel: MentalResulatViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_mental_result,
            container,
            false
        )
        viewModelFactory =
            MetalResultFactory(MentalResultFragmentArgs.fromBundle(arguments!!).quickeTestResult)
        viewModel =
            ViewModelProvider(this, viewModelFactory).get(MentalResulatViewModel::class.java)
        binding.testResult =viewModel
        binding.setLifecycleOwner(this)
        viewModel.navigateToHome.observe(viewLifecycleOwner, Observer { isNavigate->
            if(isNavigate){
                val action=MentalResultFragmentDirections.mentalResultPopUpToHome(0f)
                findNavController().navigate(action)
                viewModel.onNavigatToHomeComplete()
            }
        })

        return binding.root
    }


}
