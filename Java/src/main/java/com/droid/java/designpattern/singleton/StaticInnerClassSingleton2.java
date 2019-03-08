package com.droid.java.designpattern.singleton;

/**
 * Created by Muran Hu on 2019-03-06.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class StaticInnerClassSingleton2 {
  private StaticInnerClassSingleton2(){

  }

  public static StaticInnerClassSingleton2 getInstance() {
    return SingletonHolder.INSTANCE;
  }

  private static class SingletonHolder {
    private static final StaticInnerClassSingleton2 INSTANCE = new StaticInnerClassSingleton2();
  }
}
