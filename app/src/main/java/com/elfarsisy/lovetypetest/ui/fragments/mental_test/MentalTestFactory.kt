package com.elfarsisy.lovetypetest.ui.fragments.mental_test

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager

class MentalTestFactory(private val pager:ViewPager) : ViewModelProvider.Factory  {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MentalTestViewModel::class.java)){
            return MentalTestViewModel(pager) as T
        }
        throw IllegalArgumentException("Unknown MentalTest class")
    }
}