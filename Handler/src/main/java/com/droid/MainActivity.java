package com.droid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainThreadExecutor executor = new MainThreadExecutor();
        MyRunnable runnable = new MyRunnable();
        executor.execute(runnable);
    }
}
