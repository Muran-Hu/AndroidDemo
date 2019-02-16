package com.droid.base.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import com.droid.base.MainActivity;
import com.droid.base.R;

/**
 * Created by Muran Hu on 2019-02-14.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class MyService extends Service {

  private static final String TAG = "MyService";

  public class MyServiceProxy extends Binder {
    public void mp3Play(String name) {
      MyService.this.mp3Play(name);
    }
  }

  @Override
  public IBinder onBind(Intent intent) {
    MyServiceProxy proxy = new MyServiceProxy();
    return proxy;
  }

  @Override
  public boolean onUnbind(Intent intent) {
    Log.e(TAG, "onUnbind");
    return super.onUnbind(intent);
  }

  @Override
  public void onCreate() {
    super.onCreate();

    Log.e(TAG, "onCreate");

    showNotification();
  }

  private void showNotification() {
    Notification.Builder mBuilder = new Notification.Builder(this)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle("2016年11月24日")
            .setContentText("今天天气阴天，8到11度");

    Intent intent = new Intent(this, MainActivity.class);
    TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
    stackBuilder.addParentStack(MainActivity.class);
    stackBuilder.addNextIntent(intent);
    PendingIntent pendingIntent = stackBuilder
            .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
    mBuilder.setContentIntent(pendingIntent);
    NotificationManager nm = (NotificationManager)
            getSystemService(Context.NOTIFICATION_SERVICE);
    Notification notification = mBuilder.build();
    nm.notify(0, notification);
    startForeground(0, notification);

  }

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    Log.e(TAG, "onStartCommand");

    new Thread() {
      @Override
      public void run() {
        while (true) {
          try {
            Log.e(TAG, "run: xxxxxxxx");
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }.start();

    return super.onStartCommand(intent, flags, startId);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();

    Log.e(TAG, "onDestroy");
  }

  public void mp3Play(String name) {
    Log.e(TAG, "mp3Play: " + name);
  }
}
