package com.droid.java.designpattern;

import com.droid.java.designpattern.proxy.Moveable;
import com.droid.java.designpattern.proxy.Tank;
import com.droid.java.designpattern.proxy.TankLogProxy;
import com.droid.java.designpattern.proxy.TankTimeProxy;

public class Client {
    public static void main(String[] args) {
        Moveable moveable;

        Moveable m = new Tank();
        Moveable tlp = new TankLogProxy(m);
        Moveable ttp = new TankTimeProxy(tlp);
        moveable = ttp;
        moveable.move();
    }
}
