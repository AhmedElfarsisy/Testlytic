package com.elfarsisy.lovetypetest.ui.fragments.mental_test_prepering

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elfarsisy.lovetypetest.R

class PreperingResultsViewModel(answersList: IntArray): ViewModel() {

    var mentalDegree:Float=0f
    val correctAnswer = arrayOf(
        R.drawable.c1,
        R.drawable.c2,
        R.drawable.c3,
        R.drawable.c4,
        R.drawable.c5,
        R.drawable.c6,
        R.drawable.c7,
        R.drawable.c8,
        R.drawable.c9,
        R.drawable.c10,
        R.drawable.c11,
        R.drawable.c12,
        R.drawable.c13,
        R.drawable.c14,
        R.drawable.c15,
        R.drawable.c16,
        R.drawable.c17,
        R.drawable.c18,
        R.drawable.c19,
        R.drawable.c20,
        R.drawable.c21,
        R.drawable.c22,
        R.drawable.c23,
        R.drawable.c24,
        R.drawable.c25,
        R.drawable.c26,
        R.drawable.c27,
        R.drawable.c28,
        R.drawable.c29,
        R.drawable.c30
    )

    private val _navigateToMentalResult = MutableLiveData<Boolean>()
    val navigateToMentalResult: LiveData<Boolean>
        get() = _navigateToMentalResult

    init {
        for (i in 0..correctAnswer.size - 1) {
            if (correctAnswer[i]==answersList[i]){
                mentalDegree+=10
            }
        }
        mentalDegree=(mentalDegree*53)/100
        navigateToMentalResult()

    }
    fun navigateToMentalResult() {
        _navigateToMentalResult.value = true
    }

    fun completeNavigateToMentalResult() {
        _navigateToMentalResult.value = false
    }


    override fun onCleared() {
        super.onCleared()
    }

}