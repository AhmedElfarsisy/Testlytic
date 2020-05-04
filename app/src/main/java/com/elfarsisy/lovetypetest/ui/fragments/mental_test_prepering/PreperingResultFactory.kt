package com.elfarsisy.lovetypetest.ui.fragments.mental_test_prepering

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PreperingResultFactory(private val answersList: IntArray) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PreperingResultsViewModel::class.java)) {
            return PreperingResultsViewModel(answersList) as T
        }
        throw IllegalArgumentException("Unknown MentaResult class")
    }
}