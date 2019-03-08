package com.droid.java.designpattern.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Muran Hu on 2019-01-25.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class Coder implements Observer {

  public String name;

  public Coder(String name) {
    this.name = name;
  }


  @Override
  public void update(Observable observable, Object o) {
    System.out.println("Hi, " + name + ", DevTechFrontier has been updated, content is " + o);
  }

  @Override
  public String toString() {
    return "码农: " + name;
  }

}
