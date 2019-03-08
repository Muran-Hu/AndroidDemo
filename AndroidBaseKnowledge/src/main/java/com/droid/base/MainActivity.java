package com.droid.base;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.droid.base.service.MyIntentService;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity => ";

  Button startService;

  Intent serviceIntent;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    serviceIntent = new Intent(this, MyIntentService.class);

    startService = findViewById(R.id.startService);
    startService.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        System.out.println("onClick");
        startService(serviceIntent);
      }
    });



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
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);

    System.out.println(TAG + "onRestoreInstanceState" + " => " + savedInstanceState.getString("id"));
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
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);

    outState.putString("id", "123");

    System.out.println(TAG + "onSaveInstanceState");
  }

  /**
   * 1. 需要在Manifest中对Activity做如下配置，才会回调该方法
   *
   * android:configChanges="orientation|screenSize"
   *
   * 2. 如果做了 1 中的配置，则 Activity 不会重新创建，下面两个方法也不会被回调
   *
   * onSaveInstanceState
   * onRestoreInstanceState
   *
   * @param newConfig
   */
  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);

    System.out.println(TAG + "onConfigurationChanged");
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
