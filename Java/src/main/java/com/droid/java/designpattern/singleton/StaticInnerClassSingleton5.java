package com.droid.java.designpattern.singleton;

/**
 * Created by Muran Hu on 2019-03-08.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class StaticInnerClassSingleton5 {
  private StaticInnerClassSingleton5() {}

  public static StaticInnerClassSingleton5 getInstance() {
    return SingletonHolder.INSTANCE;
  }

  private static class SingletonHolder {
    private static final StaticInnerClassSingleton5 INSTANCE = new StaticInnerClassSingleton5();
  }
}
