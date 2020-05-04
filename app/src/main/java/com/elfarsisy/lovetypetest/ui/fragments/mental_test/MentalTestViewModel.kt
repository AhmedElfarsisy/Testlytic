package com.elfarsisy.lovetypetest.ui.fragments.mental_test

import android.os.CountDownTimer
import android.text.format.DateUtils
import android.widget.Toast
import androidx.lifecycle.*
import androidx.viewpager.widget.ViewPager
import com.elfarsisy.lovetypetest.R
import com.elfarsisy.lovetypetest.adapter.MentalQuestionAdapter
import com.elfarsisy.lovetypetest.databinding.FragmentMentalTestBinding
import com.elfarsisy.lovetypetest.model.MentalQuestion

class MentalTestViewModel(pager: ViewPager) : ViewModel() {
    companion object {
        // These represent different important times in the quiz , such as quiz length.
        // This is when the quiz is over
        private const val DONE = 0L
        // This is the number of milliseconds in a second
        private const val ONE_SECOND = 1000L
        // This is the total time of the quiz
        private const val COUNTDOWN_TIME = 1800000L
    }


    private val viewPager: ViewPager = pager


     var dataList: List<MentalQuestion>
    val mentalQuestionAdapter = MentalQuestionAdapter()

    private val timer: CountDownTimer
    private val _currentTime = MutableLiveData<Long>()
    val currentTime: LiveData<Long>
        get() = _currentTime
    // The String version of the current time
    val currentTimeString = Transformations.map(currentTime) { time ->
        DateUtils.formatElapsedTime(time)
    }

    private var _quizQuestion = MutableLiveData<List<MentalQuestion>>()
    val quizQuestion: LiveData<List<MentalQuestion>>
        get() = _quizQuestion


    private var _questionNumber = MutableLiveData<Int>()
    val questionNumber: LiveData<Int>
        get() = _questionNumber


    private val _navigateToMentalResult = MutableLiveData<Boolean>()
    val navigateToMentalResult: LiveData<Boolean>
        get() = _navigateToMentalResult




    init {
        timer = object : CountDownTimer(COUNTDOWN_TIME, ONE_SECOND) {
            override fun onTick(millisUntilFinished: Long) {
                _currentTime.value = (millisUntilFinished / ONE_SECOND)
                _questionNumber.value = getCurrentPage() + 1
            }

            override fun onFinish() {
                _currentTime.value = DONE
                navigateToMentalResult()
            }
        }
        timer.start()
        dataList = listOf(
            MentalQuestion(
                1,
                R.drawable.q1,
                R.drawable.c1,
                R.drawable.iqtest_01_02,
                R.drawable.iqtest_01_03,
                R.drawable.iqtest_01_04
            ),
            MentalQuestion(
                2,
                R.drawable.q2,
                R.drawable.iqtest_09_03,
                R.drawable.c2,
                R.drawable.iqtest_09_05,
                R.drawable.iqtest_09_06
            )
            , MentalQuestion(
                3,
                R.drawable.q3,
                R.drawable.iqtest_10_02,
                R.drawable.iqtest_10_06,
                R.drawable.c3,
                R.drawable.iqtest_10_05
            )
            , MentalQuestion(
                4,
                R.drawable.q4,
                R.drawable.iqtest_04_01,
                R.drawable.iqtest_04_04,
                R.drawable.iqtest_04_06,
                R.drawable.c4
            )
            , MentalQuestion(
                5,
                R.drawable.q5,
                R.drawable.iqtest_02_03,
                R.drawable.c5,
                R.drawable.iqtest_02_04,
                R.drawable.iqtest_02_03
            )
            , MentalQuestion(
                6,
                R.drawable.q6,
                R.drawable.iqtest_15_03,
                R.drawable.iqtest_15_05,
                R.drawable.c6,
                R.drawable.iqtest_15_01
            )
            , MentalQuestion(
                7,
                R.drawable.q7,
                R.drawable.c7,
                R.drawable.iqtest_17_04,
                R.drawable.iqtest_17_05,
                R.drawable.iqtest_17_06
            )
            , MentalQuestion(
                8,
                R.drawable.q8,
                R.drawable.iqtest_20_03,
                R.drawable.iqtest_20_04,
                R.drawable.iqtest_20_05,
                R.drawable.c8
            )
            , MentalQuestion(
                9,
                R.drawable.q9,
                R.drawable.iqtest_12_05,
                R.drawable.c9,
                R.drawable.iqtest_12_06,
                R.drawable.iqtest_12_04
            )
            , MentalQuestion(
                10,
                R.drawable.q10,
                R.drawable.c10,
                R.drawable.iqtest_18_03,
                R.drawable.iqtest_18_05,
                R.drawable.iqtest_18_06
            )
            , MentalQuestion(
                11,
                R.drawable.q11,
                R.drawable.iqtest_23_04,
                R.drawable.iqtest_23_05,
                R.drawable.iqtest_23_06,
                R.drawable.c11
            )
            , MentalQuestion(
                12,
                R.drawable.q12,
                R.drawable.iqtest_27_03,
                R.drawable.iqtest_27_01,
                R.drawable.c12,
                R.drawable.iqtest_27_02
            )
            , MentalQuestion(
                13,
                R.drawable.q13
                ,
                R.drawable.c13,
                R.drawable.iqtest_22_03,
                R.drawable.iqtest_22_06,
                R.drawable.iqtest_22_05
            )
            , MentalQuestion(
                14,
                R.drawable.q14,
                R.drawable.iqtest_28_06,
                R.drawable.iqtest_28_01,
                R.drawable.c14,
                R.drawable.iqtest_28_05
            )
            , MentalQuestion(
                15,
                R.drawable.q15,
                R.drawable.iqtest_26_02,
                R.drawable.iqtest_26_05,
                R.drawable.iqtest_26_06,
                R.drawable.c15
            )
            , MentalQuestion(
                16,
                R.drawable.q16,
                R.drawable.iqtest_31_01,
                R.drawable.c16,
                R.drawable.iqtest_31_02,
                R.drawable.iqtest_31_06
            )
            , MentalQuestion(
                17,
                R.drawable.q17,
                R.drawable.c17,
                R.drawable.iqtest_32_01,
                R.drawable.iqtest_32_02,
                R.drawable.iqtest_32_03
            )
            , MentalQuestion(
                18,
                R.drawable.q18,
                R.drawable.iqtest_35_03,
                R.drawable.iqtest_35_02,
                R.drawable.iqtest_35_01,
                R.drawable.c18
            )
            , MentalQuestion(
                19,
                R.drawable.q19,
                R.drawable.iqtest_36_01,
                R.drawable.c19,
                R.drawable.iqtest_36_02,
                R.drawable.iqtest_36_03
            )
            , MentalQuestion(
                20,
                R.drawable.q20,
                R.drawable.iqtest_39_05,
                R.drawable.iqtest_39_01,
                R.drawable.c20,
                R.drawable.iqtest_39_04
            )
            , MentalQuestion(
                21,
                R.drawable.q21,
                R.drawable.c21,
                R.drawable.iqtest_40_01,
                R.drawable.iqtest_40_07,
                R.drawable.iqtest_40_01
            )
            , MentalQuestion(
                22,
                R.drawable.q22,
                R.drawable.iqtest_42_02,
                R.drawable.c22,
                R.drawable.iqtest_42_01,
                R.drawable.iqtest_42_03
            )
            , MentalQuestion(
                23,
                R.drawable.q23,
                R.drawable.iqtest_45_02,
                R.drawable.iqtest_42_03,
                R.drawable.c23,
                R.drawable.iqtest_42_01
            )
            , MentalQuestion(
                24,
                R.drawable.q24,
                R.drawable.iqtest_43_01,
                R.drawable.iqtest_43_02,
                R.drawable.iqtest_43_03,
                R.drawable.c24
            )
            , MentalQuestion(
                25,
                R.drawable.q25,
                R.drawable.iqtest_49_02,
                R.drawable.c25,
                R.drawable.iqtest_49_03,
                R.drawable.iqtest_49_04
            )
            , MentalQuestion(
                26,
                R.drawable.q26,
                R.drawable.c26,
                R.drawable.iqtest_50_02,
                R.drawable.iqtest_50_05,
                R.drawable.iqtest_50_06
            )
            , MentalQuestion(
                27,
                R.drawable.q27,
                R.drawable.iqtest_51_01,
                R.drawable.iqtest_51_02,
                R.drawable.c27,
                R.drawable.iqtest_51_03
            )
            , MentalQuestion(
                28,
                R.drawable.q28,
                R.drawable.iqtest_52_04,
                R.drawable.iqtest_52_02,
                R.drawable.iqtest_52_01,
                R.drawable.c28
            )
            , MentalQuestion(
                29,
                R.drawable.q29,
                R.drawable.c29,
                R.drawable.iqtest_56_05,
                R.drawable.iqtest_56_02,
                R.drawable.iqtest_56_06
            )
            , MentalQuestion(
                30,
                R.drawable.q30,
                R.drawable.iqtest_57_01,
                R.drawable.iqtest_57_04,
                R.drawable.iqtest_57_05,
                R.drawable.c30
            )
        )
        _quizQuestion.value = dataList
        _questionNumber.value = getCurrentPage() + 1
    }

    fun navigateToNextQuestion() {
        if (getCurrentPage() != dataList.size - 1) {
            viewPager.setCurrentItem(getCurrentPage() + 1, true)
            viewPager.scrollBy(1, 1)
            setQuestionNumber()
        } else {
            navigateToMentalResult()
        }
    }



    fun navigateToBackQuestion() {
        if (getCurrentPage() >= 1) {
            viewPager.scrollBy(2, 2)
            viewPager.setCurrentItem(getCurrentPage() - 1, true)
            setQuestionNumber()
        } else {
        }
    }



    fun getCurrentPage() = viewPager.currentItem


    fun navigateToMentalResult() {
        _navigateToMentalResult.value = true
    }

    fun completeNavigateToMentalResult() {
        _navigateToMentalResult.value = false
    }

    fun setQuestionNumber() {
        _questionNumber.value = getCurrentPage() + 1
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }
}