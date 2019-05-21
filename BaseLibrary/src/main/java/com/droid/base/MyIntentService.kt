package com.droid.base

import android.app.IntentService
import android.content.Intent

class MyIntentService : IntentService("defaultIntentService") {

    override fun onStart(intent: Intent?, startId: Int) {
        println("onStart startId: $startId")
        super.onStart(intent, startId)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        println("onStartCommand startId: $startId")
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onHandleIntent(intent: Intent?) {
        println("onHandleIntent start")
        try {
            Thread.sleep(3000L)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        println("onHandleIntent end")
    }

    override fun onDestroy() {
        println("onDestroy")
        super.onDestroy()
    }
}
