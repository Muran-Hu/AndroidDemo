package com.droid.java.generic;

import com.droid.java.bean.Dog;
import com.droid.java.bean.Person;
import com.droid.java.bean.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class GenericDemo2 {
    public static void main(String[] args) {
        Collection<Person> coll = new ArrayList<>();
        Person p = new Person("zhangsan");
        coll.add(p);

        Collection<Student> coll2 = new ArrayList<>();
        Student s = new Student("lisi");
        coll2.add(s);

        Collection<Dog> coll3 = new ArrayList<>();
        Dog d = new Dog("wangcai");
        coll3.add(d);

        printColl(coll);
        printColl(coll2);
//        printColl(coll3);

        printColl1(coll);
        printColl1(coll2);
//        printColl1(coll3);
    }

    private static void printColl(Collection<? extends Person> collection) {
        for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }

    private static void printColl1(Collection<? super Student> collection) {
        for (Iterator iterator = collection.iterator(); iterator.hasNext();) {
            System.out.println(iterator.next());
        }
    }
}
