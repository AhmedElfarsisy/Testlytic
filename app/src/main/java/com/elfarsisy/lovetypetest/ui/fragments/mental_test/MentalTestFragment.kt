package com.elfarsisy.lovetypetest.ui.fragments.mental_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager

import com.elfarsisy.lovetypetest.R
import com.elfarsisy.lovetypetest.adapter.MentalQuestionAdapter
import com.elfarsisy.lovetypetest.databinding.FragmentMentalTestBinding

/**
 * A simple [Fragment] subclass.
 */
class MentalTestFragment : Fragment() {
    private lateinit var binding: FragmentMentalTestBinding
    private lateinit var viewModel: MentalTestViewModel
    private lateinit var pager: ViewPager
    private lateinit var adapter : MentalQuestionAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mental_test, container, false)

        viewModel = ViewModelProvider(
            this,
            MentalTestFactory(binding.viewPager)
        ).get(MentalTestViewModel::class.java)

        binding.mentalViewModel = viewModel
        binding.setLifecycleOwner(this)
        pager = binding.viewPager

        setAdapter()

        // next Question
        viewModel.navigateToMentalResult.observe(viewLifecycleOwner, Observer { isNavigate ->
            if (isNavigate) {
//                val answerArray = viewModel.getAnswer()
                val action = MentalTestFragmentDirections.actionMentalTestFragmentToPreperingMentalResultsFragment(adapter.getAswers())
                findNavController().navigate(action)

            }
        })

        // back Question


        return binding.root
    }

    private fun setAdapter() {
        adapter = MentalQuestionAdapter(viewModel.dataList)
        pager.adapter = adapter

    }


}
