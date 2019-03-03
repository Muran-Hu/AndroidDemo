package com.droid.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends Activity {

  Button startBtn;
  Button stopBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    startBtn = findViewById(R.id.start_btn);
    stopBtn = findViewById(R.id.stop_btn);

    final Intent intent = new Intent();
    intent.setAction("com.droid.demo.MY_SERVICE");

    startBtn.setOnClickListener(v -> startService(intent));

    stopBtn.setOnClickListener(v -> stopService(intent));
  }
}
