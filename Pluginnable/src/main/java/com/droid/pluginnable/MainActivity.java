package com.droid.pluginnable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        File file = new File(getCacheDir() + "/Plugin-debug.apk");
        if (!file.exists()) {
            try {
                InputStream is = getAssets().open("apk/Plugin-debug.apk");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();

                FileOutputStream fos = new FileOutputStream(file);
                fos.write(buffer);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            DexClassLoader dexClassLoader = new DexClassLoader(file.getPath(), getCacheDir().getPath(), null, null);
            Class clazz = dexClassLoader.loadClass("com.droid.plugin.utils.DateUtil");
            Object o = clazz.newInstance();
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method method: declaredMethods) {
                System.out.println(method);
                method.invoke(o);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
