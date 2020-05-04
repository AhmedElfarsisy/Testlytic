package com.elfarsisy.lovetypetest.ui.fragments.emotional_quick_test

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuickStartViewModel:ViewModel() {
    private lateinit var questions: MutableList<String>

    private var isAgree = false
    private var isDisAgree = false

    var quickTestDegree = 0

    var index = 0


    private val _liveIndex = MutableLiveData<Int>()
    val liveIndex: LiveData<Int>
        get() = _liveIndex

    var questionNumber = 0
    private val _currentQuestion = MutableLiveData<String>()
    val currentQuestion: LiveData<String>
        get() = _currentQuestion

    private val _navigateToQuickResult = MutableLiveData<Boolean>()
    val navigateToQuickResult: LiveData<Boolean>
        get() = _navigateToQuickResult


    init {
        isAgree = false
        isDisAgree = false
        setAllQuestions()
        _currentQuestion.value = questions[index]
        _liveIndex.value = ++questionNumber
    }

    private fun setAllQuestions() {
        questions = mutableListOf(
            "I find unpredictable situations exhilarating.",
            "I do things on the spur of the moment.",
            "I get bored when I have to do the same familiar things.",
            "I have a very wide range of interests",
            "I am more optimistic than most people.",
            "I am more creative than most people.",
            "I am always looking for new experiences.",
            "I am always doing new things.",
            "I am more enthusiastic than most people.",
            "I am willing to take risks to do what I want to do.",
            "I get restless if I have to stay home for any length of time.",
            "My friends would say I am very curious.",
            "I have more energy than most people.",
            "On my time off, I like to be free to do whatever looks fun.",
            "I think consistent routines keep life orderly and relaxing.",
            "I consider (and reconsider) every option thoroughly before making a plan.",
            "People should behave according to established standards of proper conduct.",
            "I enjoy planning way ahead.",
            "In general, I think it is important to follow rules.",
            "Taking care of my possessions is a high priority for me.",
            "My friends and family would say I have traditional values.",
            "I tend to be meticulous in my duties.",
            "I tend to be cautious, but not fearful.",
            "People should behave in ways that are morally correct.",
            "It is important to respect authority",
            "I would rather have loyal friends than interesting friends.",
            "Long established customs need to be respected and preserved.",
            "I like to work in a straightforward path toward completing the task.",
            "I understand complex machines easily.",
            "I enjoy competitive conversations."
        )
    }


    fun nextQuestion() {
        if (index < questions.size - 1 && (isAgree || isDisAgree)) {
            if (isAgree) {
                ++quickTestDegree

            }
            _liveIndex.value = ++questionNumber
            _currentQuestion.value = questions[++index]
        } else if (index == questions.size - 1 && (isAgree || isDisAgree)) {
            if (isAgree) {
                ++quickTestDegree

            }
            onNavigatToQuickResult()

        }
        isDisAgree = false
        isAgree = false
    }

    fun getAgree() {
        if (isDisAgree) {
            isDisAgree = false
        }
        isAgree = true
    }

    fun getDisAgree() {
        if (isAgree) {
            isAgree = false
        }
        isDisAgree = true
    }


    fun onNavigatToQuickResult() {
        _navigateToQuickResult.value = true
    }

    fun onNavigatToQuickResultComplete() {

        _navigateToQuickResult.value = false
    }

    override fun onCleared() {
        super.onCleared()
    }
}