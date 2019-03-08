package com.droid.java.set;

import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created by Muran Hu on 2019-03-07.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class LinkedHashSetDemo {
  public static void main(String args[]) {
    LinkedHashSet linkedHashSet = new LinkedHashSet();

    linkedHashSet.add(new Student("abc", 20));
    linkedHashSet.add(new Student("bcd", 21));
    linkedHashSet.add(new Student("efg", 22));
    linkedHashSet.add(new Student("cde", 24));
    linkedHashSet.add(new Student("def", 22));
    linkedHashSet.add(new Student("cde", 23));

    for (Iterator it = linkedHashSet.iterator(); it.hasNext();) {
      System.out.println(it.next());
    }
  }
}
