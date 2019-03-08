package com.droid.java.set;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by Muran Hu on 2019-03-06.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class TreeSetDemo {
  public static void main(String args[]) {

//    TreeSet treeSet = new TreeSet();

    TreeSet treeSet = new TreeSet(new CompareByName());

    treeSet.add(new Student("abc", 20));
    treeSet.add(new Student("bcd", 21));
    treeSet.add(new Student("efg", 22));
    treeSet.add(new Student("def", 22));
    treeSet.add(new Student("cde", 23));

    for (Iterator it = treeSet.iterator(); it.hasNext();) {
      System.out.println(it.next());
    }
  }
}
