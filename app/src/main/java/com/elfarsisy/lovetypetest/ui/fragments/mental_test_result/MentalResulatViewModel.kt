package com.elfarsisy.lovetypetest.ui.fragments.mental_test_result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elfarsisy.lovetypetest.R

class MentalResulatViewModel(mentalDegree:Float):ViewModel() {
    private val _ResultImage = MutableLiveData<Int>()
    val ResultImage: LiveData<Int>
        get() = _ResultImage


    private val _navigateToHome = MutableLiveData<Boolean>()
    val navigateToHome: LiveData<Boolean>
        get() = _navigateToHome



    init {
        getResult(mentalDegree)
    }

    private fun getResult(mentalDegree: Float) {
        when(mentalDegree){
            in 0f.. 80f->_ResultImage.value= R.drawable.iq_70
            in 80f..90f->_ResultImage.value=R.drawable.iq_90
            in 90f..100f->_ResultImage.value=R.drawable.iq_100
            in 100f..110f->_ResultImage.value=R.drawable.iq_110
            in 110f..120f->_ResultImage.value=R.drawable.iq_120
            in 120f..130f->_ResultImage.value=R.drawable.iq_130
            in 130f..140f->_ResultImage.value= R.drawable.iq_140
            in 140f..150f->_ResultImage.value=R.drawable.iq_150
            in 150f..160f->_ResultImage.value=R.drawable.iq_160
        }

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