package com.elfarsisy.lovetypetest.ui.fragments.emotional_quick_test_results

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class QuickResultsViewModelFactory(private val quickTestDegree: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuickResultViewModel::class.java)) {
            return QuickResultViewModel(quickTestDegree) as T
        }
        throw IllegalArgumentException("Unknown QuickViewModel class")
    }}