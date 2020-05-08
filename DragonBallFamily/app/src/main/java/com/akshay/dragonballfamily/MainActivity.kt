package com.akshay.dragonballfamily

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.akshay.dragonballfamily.data.DragonBallDao
import com.akshay.dragonballfamily.data.DragonBallEntity
import com.akshay.dragonballfamily.data.DragonBallFamilyDatabase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var dragonBallDao: DragonBallDao
    private val uiScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpDatabase()

        saveBtn.setOnClickListener {

            if (TextUtils.isEmpty(charNameEditText.text.trim().toString())) {
                Toast.makeText(this, "Please enter Dragon Ball Character name", Toast.LENGTH_LONG)
                    .show()
            } else {
                uiScope.launch {
                    insertData()
                }
            }
        }

        displayBtn.setOnClickListener {

            uiScope.launch {
                bringData()
            }
        }

        deleteDbBtn.setOnClickListener {

            uiScope.launch {
                deleteTable()
                dragonBallDao.deleteCompleteTable()
            }

        }
    }

    private fun setUpDatabase() {
        val dragonBallFamilyDatabase = DragonBallFamilyDatabase.getDatabase(this.applicationContext)
        dragonBallDao = dragonBallFamilyDatabase.dragonBallDao()
    }

    suspend private fun insertData() {
        withContext(Dispatchers.IO) {
            dragonBallDao.insert(
                DragonBallEntity(
                    name = charNameEditText.text.trim().toString()
                )
            )
        }
        charNameEditText.text.clear()
    }

    suspend private fun bringData() {
        val dataList = withContext(Dispatchers.IO) {
            dragonBallDao.getCompleteDragonBallTeam()
        }
        if (TextUtils.isEmpty(dataList.toString())) {
            displayTv.text = "Database is empty"
        } else {
            displayTv.text = dataList.toString()
        }
    }

    suspend private fun deleteTable() {
        withContext(Dispatchers.IO) {
            dragonBallDao.deleteCompleteTable()
        }
        displayTv.text = "Database is empty"
    }
}
