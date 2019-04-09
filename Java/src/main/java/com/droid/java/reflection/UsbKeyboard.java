package com.droid.java.reflection;

import com.droid.java.interfaces.Usb;

public class UsbKeyboard implements Usb {
    @Override
    public void open() {
        System.out.println("Usb keyboard open");
    }

    @Override
    public void close() {
        System.out.println("Usb keyboard close");
    }
}
