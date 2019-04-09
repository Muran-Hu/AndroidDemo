package com.droid.java.reflection;

import com.droid.java.interfaces.Usb;

public class NoteBook {
    public void useUSB(Usb usb) {
        if (null != usb) {
            usb.open();

            usb.close();
        }
    }
}
