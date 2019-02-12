package com.droid.java;

/**
 * Created by Muran Hu on 2019-02-12.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class StaticInnerClassSingleton {
  private StaticInnerClassSingleton() {}

  public static StaticInnerClassSingleton getInstance() {
    return InnerClass.INSTANCE;
  }

  private static class InnerClass {
    private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
  }
}
