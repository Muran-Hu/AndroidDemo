package com.droid.java.designpattern.singleton;

/**
 * Created by Muran Hu on 2019-03-15.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class StaticInnerClassSingleton6 {
  private StaticInnerClassSingleton6(){}

  public static StaticInnerClassSingleton6 getInstance() {
    return SingletonHolder.INSTANCE;
  }

  private static class SingletonHolder {
    private static final StaticInnerClassSingleton6 INSTANCE = new StaticInnerClassSingleton6();
  }
}
