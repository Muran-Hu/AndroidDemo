package com.droid.java.designpattern.singleton;

/**
 * Created by Muran Hu on 2019-03-07.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class StaticInnerClassSingleton4 {
  private StaticInnerClassSingleton4(){}

  public static StaticInnerClassSingleton4 getInstance() {
    return SingletonHolder.INSTANCE;
  }

  private static class SingletonHolder {
    private static final StaticInnerClassSingleton4 INSTANCE = new StaticInnerClassSingleton4();
  }
}
