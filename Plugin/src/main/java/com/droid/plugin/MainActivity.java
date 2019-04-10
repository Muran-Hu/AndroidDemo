package com.droid.plugin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.droid.plugin.utils.DateUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DateUtil dateUtil = new DateUtil();
        dateUtil.convert();
    }
}
