package com.droid.java.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Muran Hu on 2019-03-06.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class ListIteratorDemo {
  public static void main(String args[]) {
    List list = new ArrayList<String>();

    list.add("abc1");
    list.add("abc2");
    list.add("abc3");
    list.add("abc4");

    for (Iterator it1 = list.iterator(); it1.hasNext();) {
      if (it1.next().equals("abc2")) {
        it1.remove();
//        list.add("ccc");
      }
    }

    System.out.println(list);

    for (ListIterator it2 = list.listIterator(); it2.hasNext();) {
      if (it2.next().equals("abc3")) {
//        it2.add("ccc");
        System.out.println(list);
        it2.set("ddd");
        System.out.println(list);
        it2.remove();
      }
    }

    System.out.println(list);
  }
}
