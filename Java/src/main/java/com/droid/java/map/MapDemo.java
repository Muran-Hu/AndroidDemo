package com.droid.java.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Muran Hu on 2019-03-11.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class MapDemo {
  public static void main(String[] args) {
    Map<Integer, String> hashMap = new HashMap<>();
    hashMap.put(1, "zhangsan");
    hashMap.put(2, "lisi");
    hashMap.put(5, "wangwu");
    hashMap.put(4, "zhaoliu");

    Map<Integer, String> linkedHashMap = new LinkedHashMap<>();
    linkedHashMap.put(1, "zhangsan");
    linkedHashMap.put(2, "lisi");
    linkedHashMap.put(5, "wangwu");
    linkedHashMap.put(4, "zhaoliu");

    Set<Integer> keys = hashMap.keySet();
    for (Iterator it = keys.iterator(); it.hasNext();) {
      System.out.println(it.next());
    }

    Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
    for (Iterator it = entries.iterator(); it.hasNext();) {
      Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>) it.next();
      System.out.println(entry.getKey());
      System.out.println(entry.getValue());
    }

    Set<Map.Entry<Integer, String>> entries1 = linkedHashMap.entrySet();
    for (Iterator it = entries1.iterator(); it.hasNext();) {
      Map.Entry<Integer, String> next = (Map.Entry<Integer, String>) it.next();
      System.out.println(next.getKey());
      System.out.println(next.getValue());
    }
  }
}
