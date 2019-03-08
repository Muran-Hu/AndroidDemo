package com.droid.java.designpattern.singleton;

/**
 * Created by Muran Hu on 2019-03-08.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class DCLSingleton2 {
  private static DCLSingleton2 mInstance = null;
  private DCLSingleton2(){}

  public static DCLSingleton2 getInstance() {
    if (null == mInstance) {
      synchronized (DCLSingleton2.class) {
        if (null == mInstance) {
          mInstance = new DCLSingleton2();
        }
      }
    }

    return mInstance;
  }
}
