package com.droid.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) {
//        Class clazz = Dog.class;
//        System.out.println("clazz: " + clazz);
//
//        Dog dog = new Dog();
//        Class clazz1 = dog.getClass();
//        System.out.println("clazz1: " + clazz1);

        try {
            Class clazz2 = Class.forName("com.droid.java.bean.Dog");
            System.out.println("clazz: " + clazz2);

            Constructor cons = clazz2.getConstructor(int.class, String.class, String.class);
            Object object = cons.newInstance(5, "Snoopy", "Yellow");
            System.out.println(object.toString());

//            Constructor[] constructors = clazz2.getConstructors();
//            for (Constructor constructor :
//                    constructors) {
//                System.out.println(constructor);
//                Dog instance = (Dog) constructor.newInstance(10, "Jack", "red");
//                instance.toString();
//            }

            Object o = clazz2.getConstructor().newInstance();
            Method mtd = clazz2.getDeclaredMethod("pao", String.class);

            mtd.invoke(o, "James");

            Method[] methods = clazz2.getDeclaredMethods();
            for (Method method :
                    methods) {
                System.out.println(method);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
