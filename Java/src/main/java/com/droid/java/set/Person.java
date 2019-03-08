package com.droid.java.set;

/**
 * Created by Muran Hu on 2019-03-06.
 * Email: muranhu@gmail.com
 * Version: v1.0.0
 */
public class Person {
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return this.name + "," + this.age;
  }

  @Override
  public int hashCode() {
    return this.name.hashCode() + this.age;
  }

  @Override
  public boolean equals(Object o) {
    Person person = (Person)o;
    return this.name.equals(person.name);
  }
}
