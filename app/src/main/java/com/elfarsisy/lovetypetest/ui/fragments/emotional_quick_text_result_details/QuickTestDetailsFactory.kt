package com.elfarsisy.lovetypetest.ui.fragments.emotional_quick_text_result_details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class QuickTestDetailsFactory (private val quickTestResults: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(QuickTestDetailsViewModel::class.java)){
            return QuickTestDetailsViewModel(quickTestResults) as T
        }
        throw IllegalArgumentException("Unknown QuickViewModel class")
    }
}