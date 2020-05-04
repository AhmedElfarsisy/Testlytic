package com.elfarsisy.lovetypetest.ui.fragments.more_test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.elfarsisy.lovetypetest.R

/**
 * A simple [Fragment] subclass.
 */
class MoreTestFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_more_test, container, false)
    }

}
