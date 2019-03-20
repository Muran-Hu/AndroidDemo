package com.droid.java.designpattern.singleton;

/**
 * Created by Muran Hu on 2019-03-15.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class DCLSingleton3 {
  private static DCLSingleton3 mInstance = null;
  private DCLSingleton3() {}
  public static DCLSingleton3 getInstance(){
    if (null == mInstance) {
      synchronized (DCLSingleton3.class) {
        if (null == mInstance) {
          mInstance = new DCLSingleton3();
        }
      }
    }

    return mInstance;
  }
}
