package com.droid.base.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Muran Hu on 2019-03-07.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class MyIntentService extends IntentService {

  public MyIntentService() {
    super("MyIntentService");
  }

  @Override
  public void onCreate() {
    super.onCreate();

    System.out.println("onCreate");
  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    System.out.println("onStartCommand");
    return super.onStartCommand(intent, flags, startId);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();

    System.out.println("onDestroy");
  }

  @Override
  public IBinder onBind(Intent intent) {
    System.out.println("onBind");
    return super.onBind(intent);
  }

  @Override
  protected void onHandleIntent(Intent intent) {
    System.out.println("Start");
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println("Stop");
  }
}
