package com.droid.java;

/**
 * Created by Muran Hu on 2019-02-12.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class DCLSingleton {
  private static DCLSingleton singleton = null;
  private DCLSingleton() {}

  public static DCLSingleton getInstance() {
    if (null == singleton) {
      synchronized (DCLSingleton.class) {
        if (null == singleton) {
          singleton = new DCLSingleton();
        }
      }
    }

    return singleton;
  }
}
