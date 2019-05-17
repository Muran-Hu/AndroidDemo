package com.droid.java.set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Muran Hu on 2019-03-06.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class HashSetDemo {
  public static void main(String[] args){
    HashSet hashSet = new HashSet();

    hashSet.add(new Person("a0", 20));
    hashSet.add(new Person("a1", 21));
    hashSet.add(new Person("a1", 21));
    hashSet.add(new Person("a2", 22));
    hashSet.add(new Person("a3", 23));

    for (Iterator it = hashSet.iterator(); it.hasNext();) {
      System.out.println(it.next());
    }
  }
}
