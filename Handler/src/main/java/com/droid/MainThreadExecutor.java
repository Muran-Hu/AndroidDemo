package com.droid;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;

public class MainThreadExecutor implements Executor {

    private final Handler handler = new Handler(Looper.getMainLooper(), new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            return false;
        }
    });

    @Override
    public void execute(@NonNull Runnable command) {
        handler.post(command);
    }
}
