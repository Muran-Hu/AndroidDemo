package com.droid.base;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.droid.base.service.MyService;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity => ";

  Button mBtn;
  Button startService;
  Button stopService;

  Button bindService;
  Button play;

  Intent serviceIntent;
  MyServiceConnection conn = new MyServiceConnection();
  MyService.MyServiceProxy proxy;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mBtn = findViewById(R.id.mBtn);
    mBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent();

//        intent.setAction("android.intent.action.VIEW");
        intent.setAction("ANDROID_CUSTOM_ACTION_OPEN");
        intent.setDataAndType(Uri.parse("mhu://www.mhu.com:80"), "text/plain");
        startActivity(intent);
      }
    });

    serviceIntent = new Intent(this, MyService.class);

    startService = findViewById(R.id.startService);
    startService.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startService(serviceIntent);
      }
    });

    stopService = findViewById(R.id.stopService);
    stopService.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        stopService(serviceIntent);
      }
    });

    bindService = findViewById(R.id.bindService);
    bindService.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        bindService(serviceIntent, conn, BIND_AUTO_CREATE);
      }
    });

    play = findViewById(R.id.play);
    play.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        proxy.mp3Play("相信自己");
      }
    });

    System.out.println(TAG + "onCreate");
  }

  class MyServiceConnection implements ServiceConnection {
    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
      Log.e(TAG, "onServiceConnected: " + service);

      proxy = (MyService.MyServiceProxy)service;
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {
      Log.e(TAG, "onServiceDisconnected");
    }
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

    if (null != conn) {
      unbindService(conn);
      conn = null;
    }

    System.out.println(TAG + "onDestroy");
  }
}
