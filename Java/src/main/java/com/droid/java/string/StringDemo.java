package com.droid.java.string;

/**
 * Created by Muran Hu on 2019-03-04.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class StringDemo {
  public static void main(String[] args) {
    String str = "abcd";

    StringBuffer sBuffer= new StringBuffer();
    sBuffer.append('c');
    sBuffer.append("ab");
    sBuffer.append(1);
    sBuffer.append(10L);
    sBuffer.append(new Object());
    System.out.println(sBuffer.toString());

    StringBuilder sBuilder = new StringBuilder();
  }
}
