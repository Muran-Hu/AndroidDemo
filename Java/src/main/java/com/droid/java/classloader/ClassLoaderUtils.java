package com.droid.java.classloader;

import java.net.URL;

public class ClassLoaderUtils {
    public static void getBootstrapClassLoaderClassPaths() {
        URL[] urls = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url: urls) {
            System.out.println(url.toExternalForm());
        }
    }

    public static void getBootstrapClassLoaderClassPaths1() {
        System.out.println(System.getProperty("sun.boot.class.path"));
    }

    public static void getClassLoaders(Class clazz) {
        ClassLoader classLoader = clazz.getClassLoader();
        while (classLoader != null) {
            System.out.println(classLoader);
            classLoader = classLoader.getParent();
        }

        System.out.println(classLoader);
    }
}
