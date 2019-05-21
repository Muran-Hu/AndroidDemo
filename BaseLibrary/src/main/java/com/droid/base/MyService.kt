package com.droid.base

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder? {
        return MyBinder()
    }

    internal inner class MyBinder : Binder() {
        fun showLoading() {
            println("showLoading")
        }

        fun hideLoading() {
            println("hideLoading")
        }
    }
}
