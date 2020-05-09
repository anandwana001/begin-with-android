package com.akshay.dragonballquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

            if (TextUtils.isEmpty(editText.text.trim().toString())) {
                Toast.makeText(this, "Please enter the answer", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("answer", editText.text.trim().toString())
                startActivity(intent)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        askUserForPermission()
        logInUser()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
        logoutUser()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun logInUser() {

    }

    private fun askUserForPermission() {

    }

    private fun logoutUser() {

    }
}
