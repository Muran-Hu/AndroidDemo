package com.droid.demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Muran Hu on 2018-11-26.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class MyService extends Service {

  private static final String TAG = "MyService";

  @Override
  public void onCreate() {
    Log.e(TAG, "onCreate()");
    super.onCreate();
  }

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    Log.e(TAG, "onBind()");
    return null;
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    Log.e(TAG, "onStartCommand()");
    return super.onStartCommand(intent, flags, startId);
  }

  @Override
  public boolean onUnbind(Intent intent) {
    Log.e(TAG, "onUnbind()");
    return super.onUnbind(intent);
  }

  @Override
  public void onDestroy() {
    Log.e(TAG, "onDestroy()");
    super.onDestroy();
  }
}
