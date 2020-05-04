package com.elfarsisy.lovetypetest.ui.fragments.emotional_quick_test_results

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuickResultViewModel(quickTestDegree: Int) : ViewModel() {
    private val _navigateToQuickStartResult = MutableLiveData<Boolean>()
    val navigateToQuickStartResult: LiveData<Boolean>
        get() = _navigateToQuickStartResult

    private val _navigateToHome = MutableLiveData<Boolean>()
    val navigateToHome: LiveData<Boolean>
        get() = _navigateToHome


    private val _character = MutableLiveData<String>()
    val character: LiveData<String>
        get() = _character




    init {
        getPersonCharacter(quickTestDegree)
    }


    fun getPersonCharacter(testDegree: Int) {
        when (testDegree) {
            in 0..10->_character.value="Explorer"
            in 11..18->_character.value="Builder"
            in 19..25->_character.value="Director"
            in 26..30->_character.value="Negotiator"
            else->{_character.value="Do your Test frist"}
        }

    }


    fun onNavigatToQuickStartResult() {
        _navigateToQuickStartResult.value = true

    }

    fun onNavigatToQuickStartResultComplete() {
        _navigateToQuickStartResult.value = false
    }

    fun onNavigatToHome() {
        _navigateToHome.value = true

    }

    fun onNavigatToHomeComplete() {
        _navigateToHome.value = false
    }

    override fun onCleared() {
        super.onCleared()
    }
}