package com.droid;

import android.databinding.DataBindingUtil;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.droid.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        final User user = new User();
        user.name.set("zhangsan");
        binding.setUser(user);

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(3000);
                user.name.set("lisi");
            }
        }).start();
    }
}
