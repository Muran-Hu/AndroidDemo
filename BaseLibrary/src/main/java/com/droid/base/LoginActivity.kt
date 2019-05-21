package com.droid.base

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class LoginActivity : AppCompatActivity() {

    private var myBinder: MyService.MyBinder? = null
    private var mBtn: Button? = null

    private var conn: ServiceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName, service: IBinder) {
            myBinder = service as MyService.MyBinder
            myBinder!!.showLoading()
            myBinder!!.hideLoading()
        }

        override fun onServiceDisconnected(name: ComponentName) {

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mBtn = findViewById(R.id.bind_service)
        mBtn!!.setOnClickListener { v ->
            val intent = Intent(this@LoginActivity, MyService::class.java)
            bindService(intent, conn, BIND_AUTO_CREATE)
        }
    }
}
