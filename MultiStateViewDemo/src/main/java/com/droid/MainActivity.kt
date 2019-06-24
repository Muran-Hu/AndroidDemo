package com.droid

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import com.kennyc.view.MultiStateView

class MainActivity : AppCompatActivity(), MultiStateView.StateListener {

    private lateinit var multiStateView: MultiStateView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        multiStateView = findViewById(R.id.multiStateView)
        multiStateView.listener = this
        multiStateView.getView(MultiStateView.VIEW_STATE_ERROR)?.findViewById<Button>(R.id.retry)
                ?.setOnClickListener {
                    multiStateView.viewState = MultiStateView.VIEW_STATE_LOADING
                    Toast.makeText(applicationContext, "Fetching Data", Toast.LENGTH_SHORT).show()
                    multiStateView.postDelayed({ multiStateView.viewState = MultiStateView.VIEW_STATE_CONTENT }, 3000L)
                }

        val list: ListView = multiStateView.findViewById(R.id.list)

        val data = arrayOfNulls<String>(100)
        for (i in 0..99) {
            data[i] = "Row $i"
        }

        list.adapter = ArrayAdapter<String>(applicationContext, android.R.layout.simple_list_item_1, data)
    }

    override fun onStateChanged(viewState: Int) {
        Log.v("MSVSample", "onStateChanged; viewState: $viewState")
    }
}
