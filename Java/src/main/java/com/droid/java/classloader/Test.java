package com.droid.java.classloader;

import com.usercenter1.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) {
//        testDiskClassLoader1();

//        testDiskClassLoader2();

//        ClassLoaderUtils.getBootstrapClassLoaderClassPaths();
//        ClassLoaderUtils.getBootstrapClassLoaderClassPaths1();

//        ClassLoaderUtils.getClassLoaders(Person.class);
//        ClassLoaderUtils.getClassLoaders(ReflectDemo.class);
        ClassLoader classLoader = Person.class.getClassLoader();
        System.out.println("classLoader: " + classLoader);
        Person person = new Person();
        ClassLoader classLoader1 = person.getClass().getClassLoader();
        System.out.println("classLoader1: " + classLoader1);
        try {
            Class clazz = Class.forName("com.usercenter1.Person");
            Method[] declaredMethods = clazz.getDeclaredMethods();
            for (Method method: declaredMethods) {
                System.out.println(method.getName());
                method.invoke(null);
            }
            ClassLoader classLoader2 = clazz.getClassLoader();
            System.out.println("classLoader2: " + classLoader2);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void testDiskClassLoader2() {
        try {
            DiskClassLoader diskClassLoader1 = new DiskClassLoader("/Users/hmr/Desktop/test");
            DiskClassLoader diskClassLoader2 = new DiskClassLoader("/Users/hmr/Desktop/test");

            Class c1 = diskClassLoader1.loadClass("com.usercenter.Person");
            Object obj1 = c1.newInstance();

            Class c2 = diskClassLoader2.loadClass("com.usercenter.Person");
            Object obj2 = c2.newInstance();

            Method method = c1.getMethod("setPerson", Object.class);
            method.invoke(obj1, obj2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void testDiskClassLoader1() {
        /**
         * 加载磁盘class文件
         * 注：本地项目不能有和磁盘文件相同包名，类名的类，否则会
         */
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
