package com.droid.java;

import com.droid.java.designpattern.observer.Coder;
import com.droid.java.designpattern.observer.DevTechFrontier;

/**
 * Created by Muran Hu on 2018-12-24.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class Main {
  public static void main(String args[]) {
    Coder coder = new Coder("mr.simple");
    Coder coder1 = new Coder("coder-1");
    Coder coder2 = new Coder("coder-2");
    Coder coder3 = new Coder("coder-3");

    DevTechFrontier devTechFrontier = new DevTechFrontier();

    devTechFrontier.addObserver(coder);
    devTechFrontier.addObserver(coder1);
    devTechFrontier.addObserver(coder2);
    devTechFrontier.addObserver(coder3);

    devTechFrontier.postNewPublication("Hello");
  }
}
