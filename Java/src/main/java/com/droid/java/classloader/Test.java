package com.droid.java.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
        DiskClassLoader diskClassLoader = new DiskClassLoader("/Users/hmr/Desktop/test");
        try {
            Class c = diskClassLoader.loadClass("com.usercenter.Person");
            if (c != null) {
                Object obj = c.newInstance();
                System.out.println(obj.getClass().getClassLoader());
                Method method = c.getDeclaredMethod("say", null);
                method.invoke(obj, null);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
