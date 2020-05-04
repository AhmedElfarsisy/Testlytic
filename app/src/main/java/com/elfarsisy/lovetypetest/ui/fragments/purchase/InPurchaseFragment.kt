package com.elfarsisy.lovetypetest.ui.fragments.purchase

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.elfarsisy.lovetypetest.R
import com.elfarsisy.lovetypetest.databinding.FragmentInPurchaseBinding


class InPurchaseFragment : Fragment() {
    private lateinit var binding: FragmentInPurchaseBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_in_purchase, container, false)
        binding.setLifecycleOwner(this)
        binding.purchase1.setOnClickListener { navigateToResults() }
        binding.purchase2.setOnClickListener { navigateToResults() }
        binding.purchase3.setOnClickListener { navigateToResults() }
        binding.closeBrainStart.setOnClickListener { navigateToHome() }
        return binding.root
    }

    fun navigateToHome() {
        val action = InPurchaseFragmentDirections.actionInPurchaseFragmentToHomeFragment()
        findNavController().navigate(action)
    }

    fun navigateToResults() {
        //get from preferences
        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        val quickTestDegree = sharedPref.getInt("quickTestDegree", -1)
        //navigate
        val action =
            InPurchaseFragmentDirections.actionInPurchaseFragmentToQuickTestResultsFragment(
                quickTestDegree
            )
        findNavController().navigate(action)
    }


}
