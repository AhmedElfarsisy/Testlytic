package com.elfarsisy.lovetypetest.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel:ViewModel() {
    private val _navigateToQuickStart = MutableLiveData<Boolean>()
    val navigateToQuickStart: LiveData<Boolean>
        get() = _navigateToQuickStart

    private val _navigateToMentalTest = MutableLiveData<Boolean>()
    val navigateToMentalTest: LiveData<Boolean>
        get() = _navigateToMentalTest

    private val _navigateToResult = MutableLiveData<Boolean>()
    val navigateToResult: LiveData<Boolean>
        get() = _navigateToResult

    private val _navigateToMoreTests = MutableLiveData<Boolean>()
    val navigateToMoreTests: LiveData<Boolean>
        get() = _navigateToMoreTests

    init {
        _navigateToQuickStart.value = false
        _navigateToMentalTest.value = false
        _navigateToMoreTests.value = false
        _navigateToResult.value = false
    }


    fun onNavigatToQuickTest() {
        _navigateToQuickStart.value = true

    }

    fun onNavigatToQuickTestComplete() {
        _navigateToQuickStart.value = false
    }

    fun onNavigatToMentalTest() {
        _navigateToMentalTest.value = true

    }

    fun onNavigatToMentalTestComplete() {
        _navigateToMentalTest.value = false
    }

    fun onNavigatToMoreTests() {
        _navigateToMoreTests.value = true

    }

    fun onNavigatToMoreTestsComplete() {
        _navigateToMoreTests.value = false
    }

    fun onNavigatToResult() {
        _navigateToResult.value = true
    }

    fun onNavigatToResultComplet() {
        _navigateToResult.value = false
    }

    override fun onCleared() {
        super.onCleared()
    }
}