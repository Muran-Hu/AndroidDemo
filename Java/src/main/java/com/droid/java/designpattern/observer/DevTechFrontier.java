package com.droid.java.designpattern.observer;

import java.util.Observable;

/**
 * Created by Muran Hu on 2019-01-25.
 * Email: muranhu@gmail.com
 * Version v1.0.0
 */
public class DevTechFrontier extends Observable {
  public void postNewPublication(String content) {
    setChanged();

    notifyObservers(content);
  }
}
