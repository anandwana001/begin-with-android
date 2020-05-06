package com.akshay.samplequiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intentData = intent.getStringExtra("answer")
        intentData?.let {
            if(it.equals("3.14"))
                resTextView.text = " $it is correct"
            else
                resTextView.text = " $it is wrong"
        }
    }
}
