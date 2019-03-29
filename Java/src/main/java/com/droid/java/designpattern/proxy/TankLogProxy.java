package com.droid.java.designpattern.proxy;

public class TankLogProxy implements Moveable {
    Moveable m;

    public TankLogProxy(Moveable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("before:");
        m.move();
        System.out.println("end");
    }
}
