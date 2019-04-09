package com.droid.java.reflection;

import com.droid.java.interfaces.Usb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReflectDemo2 {
    public static void main(String[] args) {
        try {
            NoteBook book = new NoteBook();

            File file = new File("Java/usb.properties");
            FileInputStream fis = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fis);
            for (int i = 1; i <= properties.size(); i++) {
                String className = properties.getProperty("usb" + i);
                System.out.println(className);
                Class clazz = Class.forName(className);
                Usb usb = (Usb)clazz.newInstance();
                book.useUSB(usb);
            }

            fis.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
