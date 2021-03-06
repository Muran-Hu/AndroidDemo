package com.droid.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  Button startBtn;
  Button stopBtn;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    startBtn = findViewById(R.id.start_btn);
    stopBtn = findViewById(R.id.stop_btn);

    TextView textView = new TextView(this);
    textView.setText("aaaa");

    final Intent intent = new Intent();
    intent.setAction("com.droid.demo.MY_SERVICE");

    startBtn.setOnClickListener(v -> startService(intent));

    stopBtn.setOnClickListener(v -> stopService(intent));
  }
}
