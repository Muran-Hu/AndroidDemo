package com.droid.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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

    startBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startService(intent);
      }
    });

    stopBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        stopService(intent);
      }
    });
  }
}
