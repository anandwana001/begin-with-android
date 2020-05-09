package com.akshay.dragonballnotify

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.VISIBILITY_PUBLIC
import androidx.core.app.NotificationManagerCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var builder: NotificationCompat.Builder

    private var CHANNEL_ID = "GOKU"
    private var CHANNEL_NAME = "Dragon Ball Channel"
    private var CHANNEL_DESCRIPTION = "Find Dragon Ball notify Channel"

    private val NOTIFICATION_ID = 1

    private lateinit var pendingIntent: PendingIntent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        notifyBtn.setOnClickListener {

            createPendingIntent()
            createNotificationBuilder()
            createNotificationChannelAndSetToManager()

            with(NotificationManagerCompat.from(this)) {
                notify(NOTIFICATION_ID, builder.build())
            }
        }
    }

    private fun createPendingIntent() {
        val intent = Intent(this, SecondActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        intent.putExtra("key", "Cool!! You had find one dragon ball.")
        pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
    }

    private fun createNotificationBuilder() {
        builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.android)
            .setContentTitle("Found one Dragon Ball")
            .setContentText("Kame House (カメハウス Kame Hausu) is a house")
            .setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Kame House (カメハウス Kame Hausu) is a house on a very small island in the middle of the sea. It is the home of Master Roshi. It also becomes Krillin's permanent residence.")
            )
            .setStyle(
                NotificationCompat.BigPictureStyle()
                    .bigPicture(BitmapFactory.decodeResource(this.resources, R.drawable.kamehouse))
            )
            .setVisibility(VISIBILITY_PUBLIC)
            .setContentIntent(pendingIntent)
    }

    private fun createNotificationChannelAndSetToManager() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = CHANNEL_NAME
            val descriptionText = CHANNEL_DESCRIPTION
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }
}
