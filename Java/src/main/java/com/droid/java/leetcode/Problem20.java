package com.droid.java.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by Muran Hu on 2019-03-07.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class Problem20 {

  private static HashMap<String, String> hashMap = new HashMap<>();
  private static Stack stack = new Stack();

  public static void main(String[] args) {

    hashMap.put("(", ")");
    hashMap.put("{", "}");
    hashMap.put("[", "]");

    String str = "([)]";

    boolean isValid = isValid(str);

    System.out.println(isValid);
  }

  private static boolean isValid(String str) {
    char[] chars = str.toCharArray();
    System.out.println(chars);
    for (char c: chars) {
      String s = String.valueOf(c);
      if (hashMap.containsKey(s)) {
        stack.push(s);
      } else if (hashMap.containsValue(s)) {
        if (!stack.isEmpty()) {
          String left = (String) stack.pop();
          String right = hashMap.get(left);
          if (!right.equals(s)) {
            return false;
          }
        } else {
          return false;
        }
      }
    }

    return stack.isEmpty();
  }
}
