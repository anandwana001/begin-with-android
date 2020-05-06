package com.akshay.samplequiz.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.akshay.samplequiz.R
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * Created by akshaynandwana on
 * 06, May, 2020
 **/
class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val argumentData = arguments?.let {
            it.getString("answer")
        }

        argumentData?.let {
            if (it.equals("3.14"))
                resTextView.text = " $it is correct"
            else
                resTextView.text = " $it is wrong"
        }
    }
}