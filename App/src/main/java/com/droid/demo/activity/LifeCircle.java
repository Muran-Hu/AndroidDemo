package com.droid.demo.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.droid.demo.R;

/**
 * Created by Muran Hu on 2018-12-23.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class LifeCircle extends AppCompatActivity {
  int b;
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.life_circle);
    String name = null;
    int a;
    if (null != savedInstanceState) {
      name = savedInstanceState.getString("name");
    }
    System.out.println("onCreate bundle: " + name + b);
  }

  @Override
  protected void onStart() {
    super.onStart();
    System.out.println("onStart");
  }

  @Override
  protected void onResume() {
    super.onResume();
    System.out.println("onResume");
  }

  @Override
  protected void onPause() {
    super.onPause();
    System.out.println("onPause");
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    outState.putString("name", "zhangsan");
    super.onSaveInstanceState(outState);
    System.out.println("onSaveInstanceState");
  }

  @Override
  protected void onStop() {
    super.onStop();
    System.out.println("onStop");
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    System.out.println("onDestroy");
  }

}
