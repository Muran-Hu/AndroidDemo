package com.droid.java.designpattern.proxy;

public class Tank implements Moveable{
    @Override
    public void move() {
        System.out.println("Tank is moving...");
    }
}
