package com.droid.java.reflection;

import java.lang.reflect.Field;

public class ReflectDemo1 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("com.droid.java.bean.Dog");
            Object o = clazz.newInstance();
//            Field[] fields = clazz.getFields();
//            for (Field field :
//                    fields) {
//                System.out.println(field);
//            }

//            Field[] declaredFields = clazz.getDeclaredFields();
//            for (Field field :
//                    declaredFields) {
//                System.out.println(field);
//            }
//
            Field gender = clazz.getDeclaredField("gender");
            gender.setInt(o, 20);
            System.out.println(gender.get(o));

            Field name = clazz.getDeclaredField("name");
            name.setAccessible(true);
            name.set(o, "zhangsan");
            System.out.println(name.get(o));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
