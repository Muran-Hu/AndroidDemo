package com.droid.java.reflection;

import com.droid.java.interfaces.Usb;

public class UsbMouse implements Usb {
    @Override
    public void open() {
        System.out.println("Usb mouse open");
    }

    @Override
    public void close() {
        System.out.println("Usb mouse close");
    }
}
