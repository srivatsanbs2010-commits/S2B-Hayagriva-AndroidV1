package com.s2b.hayagriva.voice

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.s2b.hayagriva.R

/**
 * Scaffold for the always-listening wake-word service.
 * A production implementation should use a dedicated on-device
 * wake-word engine and explicit user permission/consent.
 */
class WakeWordService : Service() {
    override fun onCreate() {
        super.onCreate()
        val channelId = "hayagriva_voice"
        val nm = getSystemService(NotificationManager::class.java)
        nm.createNotificationChannel(
            NotificationChannel(
                channelId,
                "Hayagriva Voice",
                NotificationManager.IMPORTANCE_LOW
            )
        )
        val notification: Notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("S2B Hayagriva")
            .setContentText("Voice assistant is active")
            .setSmallIcon(android.R.drawable.ic_btn_speak_now)
            .build()
        startForeground(1001, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        // TODO: Connect an on-device wake-word detector.
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
