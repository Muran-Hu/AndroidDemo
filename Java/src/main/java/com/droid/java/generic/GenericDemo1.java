package com.droid.java.generic;

import com.droid.java.bean.Person;
import com.droid.java.bean.Student;

import java.util.ArrayList;
import java.util.Collection;

public class GenericDemo1 {
    public static void main(String[] args) {
        Collection<Person> coll = new ArrayList<>();
        Person p = new Person("zhangsan");

        Student s = new Student("lisi");

        GenericClassDemo demo = new GenericClassDemo();
        demo.set(p);
        System.out.println(demo.get());

        demo.set(s);
        System.out.println(demo.get());

        Tool<String> t = new Tool<>();
        t.show("asdfas");

        t.myPrint("sdfds");
        t.myPrint(new Integer(4));
    }
}

class GenericClassDemo<T> {
    T t;

    GenericClassDemo() {

    }

    void set(T t) {
        this.t = t;
    }

    T get() {
        return this.t;
    }
}

class Tool<E> {
    void show(E e) {
        System.out.println(e.toString());
    }

    <T> void myPrint(T t) {
        System.out.println(t.toString());
    }
}
