package com.akshay.dragonballquiz

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intentData = intent.getStringExtra("answer")
        intentData?.let {
            if(it.equals("kakarot"))
                resTextView.text = " $it is correct"
            else
                resTextView.text = " $it is wrong, correct answer is kakarot"
        }
    }
}
