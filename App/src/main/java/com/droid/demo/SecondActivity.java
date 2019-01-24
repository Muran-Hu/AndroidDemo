package com.droid.demo;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Muran Hu on 2018-12-22.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class SecondActivity extends AppCompatActivity {

  TextView mTextView;
  String str;
  StringBuilder stringBuilder;
  StringBuffer stringBuffer;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.second);

    mTextView = findViewById(R.id.view);

    ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
    int memory = manager.getMemoryClass();
    int largeMemory = manager.getLargeMemoryClass();

    mTextView.setText("Memory: " + memory + "\n" + "largeMemory: " + largeMemory);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    System.out.println("onDestroy");
  }
}
