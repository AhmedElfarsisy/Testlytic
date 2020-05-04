package com.elfarsisy.lovetypetest.ui.fragments.mentalresult

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.elfarsisy.lovetypetest.ui.fragments.mental_test_result.MentalResulatViewModel

class MetalResultFactory(private val mentalDegree: Float) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MentalResulatViewModel::class.java)) {
            return MentalResulatViewModel(mentalDegree) as T
        }
        throw IllegalArgumentException("Unknown MentaResult class")
    }
}