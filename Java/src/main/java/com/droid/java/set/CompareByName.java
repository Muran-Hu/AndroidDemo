package com.droid.java.set;

import java.util.Comparator;

/**
 * Created by Muran Hu on 2019-03-07.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class CompareByName implements Comparator {
  @Override
  public int compare(Object o, Object t1) {
    Student s1 = (Student)o;
    Student s2 = (Student)t1;

    int tmp = s1.getName().compareTo(s2.getName());

    return tmp == 0 ? s1.getAge() - s2.getAge() : tmp;
  }
}
