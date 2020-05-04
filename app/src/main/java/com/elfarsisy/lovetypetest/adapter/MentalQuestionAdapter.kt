package com.elfarsisy.lovetypetest.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import com.elfarsisy.lovetypetest.databinding.MentalTestItemBinding
import com.elfarsisy.lovetypetest.model.MentalQuestion

class MentalQuestionAdapter() : PagerAdapter() {

    private lateinit var mData: List<MentalQuestion>
    private val answerList = IntArray(30) { 0 }
    constructor(dataList: List<MentalQuestion>) : this() {
        mData = dataList
    }




    private lateinit var binding: MentalTestItemBinding
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        binding = MentalTestItemBinding.inflate(LayoutInflater.from(container.context))
        val question = binding.questionImageView
        val answer1 = binding.answer1RadioBtn
        val answer2 = binding.answer2RadioBtn
        val answer3 = binding.answer3radioBtn
        val answer4 = binding.answer4radioBtn
        question.setImageResource(mData. get (position).imageQuestion)
        answer1.setCompoundDrawablesWithIntrinsicBounds(0, 0, mData.get(position).imageAnswer1, 0)
        answer2.setCompoundDrawablesWithIntrinsicBounds(0, 0, mData.get(position).imageAnswer2, 0)
        answer3.setCompoundDrawablesWithIntrinsicBounds(0, 0, mData.get(position).imageAnswer3, 0)
        answer4.setCompoundDrawablesWithIntrinsicBounds(0, 0, mData.get(position).imageAnswer4, 0)
        answer1.setOnClickListener{
            answerList.set(position, mData.get(position).imageAnswer1)
            Toast.makeText(container.context,""+answerList[position],Toast.LENGTH_SHORT)
            answer1.isChecked = true
            answer2.isChecked = false
            answer3.isChecked = false
            answer4.isChecked = false
        }
        answer2.setOnClickListener{
            answerList.set(position, mData.get(position).imageAnswer2)
            answer1.isChecked = false
            answer2.isChecked = true
            answer3.isChecked = false
            answer4.isChecked = false
        }
        answer3.setOnClickListener{
            answerList.set(position, mData.get(position).imageAnswer3)
            answer1.isChecked = false
            answer2.isChecked = false
            answer3.isChecked = true
            answer4.isChecked = false
        }
        answer4.setOnClickListener{
            answerList.set(position, mData.get(position).imageAnswer4)
            answer1.isChecked = false
            answer2.isChecked = false
            answer3.isChecked = false
            answer4.isChecked = true
        }

        container.addView(binding.root)
        return binding.root
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return mData.size
    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    fun getAswers(): IntArray {
        return answerList
    }


}
