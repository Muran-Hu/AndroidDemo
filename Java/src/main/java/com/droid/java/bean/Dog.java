package com.droid.java.bean;

public class Dog extends Animal{
    private int age;
    private String name;
    private String color;
    public int gender;

    public Dog() {

    }

    public Dog(int age) {
        this.age = age;
    }

    public Dog(String name) {
        this.name = name;
    }

    public Dog(int age, String name, String color) {
        this.age = age;
        this.name = name;
        this.color = color;
    }

    public void run(String name) {
        System.out.println(name + " is running...");
    }

    public static void pao(String name) {
        System.out.println(name + " is paoing...");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "[" + this.name + ", " + this.age + ", " + this.color + "]";
    }
}
