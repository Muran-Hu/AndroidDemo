package com.droid.java.designpattern.proxy;

import java.util.Random;

public class TankTimeProxy implements Moveable {
    Moveable m;

    public TankTimeProxy(Moveable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        System.out.println("start time: " + start);
        m.move();
        try {
            Thread.sleep(new Random().nextInt(10000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("end time: " + end);
    }
}
