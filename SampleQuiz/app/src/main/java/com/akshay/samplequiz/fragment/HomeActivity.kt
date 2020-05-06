package com.akshay.samplequiz.fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.akshay.samplequiz.R

/**
 * Created by akshaynandwana on
 * 06, May, 2020
 **/
class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FirstFragment())
            .commit()

    }
}