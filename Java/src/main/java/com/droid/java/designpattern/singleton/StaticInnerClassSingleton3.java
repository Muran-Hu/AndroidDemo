package com.droid.java.designpattern.singleton;

/**
 * Created by Muran Hu on 2019-03-07.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class StaticInnerClassSingleton3 {
  private StaticInnerClassSingleton3(){}

  public static StaticInnerClassSingleton3 getInstance() {
    return SingletonHolder.INSTANCE;
  }

  private static class SingletonHolder {
    private static final StaticInnerClassSingleton3 INSTANCE = new StaticInnerClassSingleton3();
  }
}
