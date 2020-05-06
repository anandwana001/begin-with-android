package com.akshay.samplequiz.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.akshay.samplequiz.R
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * Created by akshaynandwana on
 * 06, May, 2020
 **/
class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button.setOnClickListener {

            if (TextUtils.isEmpty(editText.text.trim().toString())) {
                Toast.makeText(context, "Please enter the answer", Toast.LENGTH_LONG).show()
            } else {
                activity?.let {

                    val bundle = Bundle().apply {
                        putString("answer", editText.text.trim().toString())
                    }

                    val secondFragment = SecondFragment()
                    secondFragment.arguments = bundle

                    it.supportFragmentManager.beginTransaction()
                        .replace(R.id.container, secondFragment)
                        .addToBackStack(null)
                        .commit()
                }

            }
        }

    }


}