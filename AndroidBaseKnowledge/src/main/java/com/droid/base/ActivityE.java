package com.droid.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ActivityE extends AppCompatActivity {

  private static final String TAG = "ActivityE => ";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_e);

    System.out.println(TAG + "onCreate");
  }

  @Override
  protected void onRestart() {
    super.onRestart();

    System.out.println(TAG + "onRestart");
  }

  @Override
  protected void onStart() {
    super.onStart();

    System.out.println(TAG + "onStart");
  }

  @Override
  protected void onResume() {
    super.onResume();

    System.out.println(TAG + "onResume");
  }

  @Override
  protected void onPause() {
    super.onPause();

    System.out.println(TAG + "onPause");
  }

  @Override
  protected void onStop() {
    super.onStop();

    System.out.println(TAG + "onStop");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();

    System.out.println(TAG + "onDestroy");
  }
}
