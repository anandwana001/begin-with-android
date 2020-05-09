package com.akshay.dragonballnotify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

/**
 * Created by akshaynandwana on
 * 09, May, 2020
 **/
class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        pendingIntentTv.text = intent.getStringExtra("key")

    }
}