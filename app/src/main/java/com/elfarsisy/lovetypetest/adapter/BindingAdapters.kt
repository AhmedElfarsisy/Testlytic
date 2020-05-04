package com.elfarsisy.lovetypetest.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("getResult")
fun bindResultImage(questionImageView: ImageView, resourceImage: Int) {
    questionImageView.setImageResource(resourceImage)
}