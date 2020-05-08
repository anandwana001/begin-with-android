package com.akshay.dragonballtest

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        validateBtn.setOnClickListener {

            if (TextUtils.isEmpty(enterEmailEt.text.trim().toString())) {
                Toast.makeText(this, "Please enter a email", Toast.LENGTH_LONG).show()
            } else {
                displayResultTv.text =
                    Util.validateEmail(enterEmailEt.text.trim().toString()).toString()
            }
        }
    }


}
