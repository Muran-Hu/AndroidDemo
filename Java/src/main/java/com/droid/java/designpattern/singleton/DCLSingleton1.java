package com.droid.java.designpattern.singleton;

/**
 * Created by Muran Hu on 2019-03-07.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class DCLSingleton1 {
  private static DCLSingleton1 dclSingleton;

  private DCLSingleton1() {

  }

  public static DCLSingleton1 getInstance() {
    if (null == dclSingleton) {
      synchronized (DCLSingleton1.class) {
        if (null == dclSingleton) {
          dclSingleton = new DCLSingleton1();
        }
      }
    }

    return dclSingleton;
  }
}
