package com.elfarsisy.lovetypetest.ui.fragments.emotional_quick_text_result_details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class QuickTestDetailsViewModel(quickTestResults: String) : ViewModel() {
    val character = quickTestResults

    private val _navigateToHome = MutableLiveData<Boolean>()
    val navigateToHome: LiveData<Boolean>
        get() = _navigateToHome


    private val _characterDetails = MutableLiveData<String>()
    val characterDetails: LiveData<String>
        get() = _characterDetails

    init {
        getCharacterDetails()
    }

    private fun getCharacterDetails() {
        when (character) {
            "Explorer" -> _characterDetails.value ="Among Explorers, similarity attracts, so another Explorer is a good match.You are born free. They express more of the traits linked with the dopamine system in the brain. These men and women love novelty; they are willing to take risks to experience adventures of the mind and/or body. They are optimistic, energetic, spontaneous, mentally flexible, often generous and highly curious and creative. And they often seek a partner who will go adventuring with them: another Explorer. Because they are friendly and enthusiastic, have little interest in rules or schedules, and have no desire to control others they can make a date feel comfortable quickly. Explorers are also good at listening and talking. They are inquisitive, so they are likely to ask you about yourself in order to engage you and satisfy their curiosity. But they tend to play the field and seek as much freedom and variety as possible—until they are ready to settle down."
            "Builder" -> _characterDetails.value ="They are pillars of society. Most likely highly expressive of the serotonin system in the brain, they are traditional and conventional, as well as cautious, calm and often social. These men and women like to build networks; community and family are important to them. They make good managers because they are orderly, conscientious, thorough and loyal. And they respect rules and like schedules. Builders seek a stable and predictable team player, someone who shares their fidelity to family and tradition. They take courtship seriously, too. Builders don’t choose a partner impulsively. They believe in good manners, old-fashioned courtesy, punctuality and well-arranged schedules. Builders tend to think concretely; they are literal; they like and trust facts. So on a date, a Builder is likely to engage in tangible conversations - about food, travel, sports, the weather, TV programs and/or movies. They are often good at “small talk,” short conversations on concrete topics. They can be very modest when discussing their achievements. And they tend to take the opinions of their friends and relatives seriously."
            "Director" -> _characterDetails.value ="Among Directors, opposites attract, like Negotiators. They shoot for the stars. These men (and women) express traits linked with the testosterone system in the brain. They tend to excel at analytical and strategic thinking. They are also direct, decisive, exacting and tough minded. Directors are good at what scientists call “rule-based systems,” aptitudes such as higher math, mechanics, computers, engineering and/or music. And they are often competitive, as well as skeptical and emotionally contained. Directors approach dating and relationships the same way they approach their other interests, by rationally analyzing their hopes, needs and intentions. Foremost they seek a partner who shares their goals, as well as someone who is eager to exchange ideas, build theories and talk about science, philosophy, history or whatever interests them. To balance out their forthright style and tendency to make decisions quickly, Directors tend to gravitate to partners who weigh alternatives, listen actively, handle conflicts deftly and have other well-honed social skills. Because they analyze their own emotions, as well as hide them, Directors tend to seek mates who are emotionally expressive. Because they have difficulty dealing with “controlling” people, they tend to be attracted to those who are flexible, even indecisive. Thus they often gravitate to Negotiators who have the empathy and emotional complexity to handle their forceful personalities."
            "Negotiator" -> _characterDetails.value ="Negotiators are attracted by directors! They are philosophers. These women (and men) express traits linked with the estrogen system in the brain. These people see the big picture. They are imaginative and intuitive. They have superb language and people skills. They are also emotionally expressive, as well as agreeable, trusting and compassionate. Negotiators seek someone with whom they can make an intensely intimate, deeply meaningful, inspiring and spiritual connection. But Negotiators, like Directors, prefer to go out with one person at a time and to explore the depths of this potential partnership. They dislike wasting time on irrelevant, trivial or boring socializing. When they find “The One,” Negotiators are superb at generating and maintaining intimacy with this partner. They avoid conflicts with a mate, and make major personal adjustments to strengthen this cherished bond. They give thoughtful gifts, such as a treasured book or photograph. They share their most personal feelings. And they want their partner to share his or her feelings too."

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