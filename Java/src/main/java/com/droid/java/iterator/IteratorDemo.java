package com.droid.java.iterator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Muran Hu on 2019-03-06.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class IteratorDemo {
  public static void main(String args[]) {
    Collection coll = new ArrayList();
    ((ArrayList) coll).add("abc1");
    ((ArrayList) coll).add("abc2");
    ((ArrayList) coll).add("abc3");

    // 第一种写法
    Iterator it = coll.iterator();
    while (it.hasNext()) {
      System.out.println(it.next());
    }

    // 第二种写法，老外写法，建议开发时这样写
    for (Iterator iterator = coll.iterator(); iterator.hasNext();) {
      System.out.println(iterator.next());
    }

    // Note: 方法二与方法一相比，循环之后 iterator 对象就没有了，可以被回收了
  }
}
