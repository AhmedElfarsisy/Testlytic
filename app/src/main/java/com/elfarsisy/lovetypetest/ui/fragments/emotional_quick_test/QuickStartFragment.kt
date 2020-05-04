package com.elfarsisy.lovetypetest.ui.fragments.emotional_quick_test

import android.content.Context
import android.os.Bundle
import android.provider.Settings.Global.putInt
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.elfarsisy.lovetypetest.R
import com.elfarsisy.lovetypetest.databinding.FragmentQuickStartBinding
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds

/**
 * A simple [Fragment] subclass.
 */
class QuickStartFragment : Fragment() {
    private lateinit var binding: FragmentQuickStartBinding
    private lateinit var viewModel: QuickStartViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_quick_start, container, false)
        viewModel = ViewModelProvider(this).get(QuickStartViewModel::class.java)
        binding.quickStartViewModel = viewModel
        binding.setLifecycleOwner(this)
        //funcation to get ads
        getAds()

        viewModel.navigateToQuickResult.observe(viewLifecycleOwner, Observer { isNavigate ->
            if (isNavigate) {

                val quickTestDegree = viewModel.quickTestDegree
                val action =
                    QuickStartFragmentDirections.actionQuickStartFragmentToQuickTestResultsFragment(
                        quickTestDegree
                    )
                findNavController().navigate(action)
                val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE)
                with(sharedPref?.edit()) {
                    this?.putInt("quickTestDegree", quickTestDegree)
                        ?.commit()
                }
            }
        })
        return binding.root
    }

    private fun getAds() {

        MobileAds.initialize(context) {}
        val adRequest = AdRequest.Builder()
            .build()
        binding.adView.loadAd(adRequest)
        binding.adView2.loadAd(adRequest)


    }

}




