package com.droid.rx;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = "MainActivity: ";

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

//    test1();
//
//    test2();
//
//    test3();
//
//    test4();
//
    test5();

    test6();
  }

  /**
   * 操作符 - zip
   */
  private void test6() {
    final Observable<Integer> observable1 = new Observable<Integer>() {
      @Override
      protected void subscribeActual(Observer<? super Integer> observer) {
        observer.onNext(1);
        observer.onNext(2);
//        observer.onNext(3);
        observer.onComplete();
      }
    };
    Observable<String> observable2 = new Observable<String>() {
      @Override
      protected void subscribeActual(Observer<? super String> observer) {
        observer.onNext("A");
        observer.onNext("B");
        observer.onNext("C");
        observer.onComplete();
      }
    };

    Observable.zip(observable1,
                   observable2,
                   new BiFunction<Integer, String, String>() {
                     @Override
                     public String apply(Integer integer, String s) throws Exception {
                       return integer.intValue() + s;
                     }
                   })
              .subscribeOn(Schedulers.io())
              .observeOn(AndroidSchedulers.mainThread())
              .subscribe(new Consumer<String>() {
                @Override
                public void accept(String s) throws Exception {
                  System.out.println(TAG + s);
                }
              });
  }

  /**
   * 操作符 - merge
   */
  private void test5() {
    List<Integer> list1 = new ArrayList<>();
    list1.add(1);
    list1.add(2);
    list1.add(3);

    List<String> list2 = new ArrayList<>();
    list2.add("a");
    list2.add("b");
    list2.add("c");

    Observable<List<Integer>> observable1 = Observable.fromArray(list1);
    Observable<List<String>> observable2 = Observable.fromArray(list2);

    Observable.merge(observable1, observable2)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<Object>() {
              @Override
              public void accept(Object o) throws Exception {
                System.out.println(TAG + o.toString());
              }
            });
  }

  class Person {
    String name;
    int age;
    Person(String name, int age) {
      this.name = name;
      this.age = age;
    }
  }

  class User {
    String username;
    User(String username) {
      this.username = username;
    }
  }

  /**
   * 操作符 - flatMap、map、filter、take、doOnNext
   */
  private void test4() {
    Observable.fromArray("zhangsan", "lisi", "wangwu")
            // 字符串转换成User对象
            .flatMap(new Function<String, ObservableSource<User>>() {
              @Override
              public ObservableSource<User> apply(String s) throws Exception {
                return Observable.fromArray(new User(s));
              }
            })
            // User对象转换成Person对象
            .flatMap(new Function<User, ObservableSource<Person>>() {
              @Override
              public ObservableSource<Person> apply(User user) throws Exception {
                return Observable.fromArray(new Person(user.username, user.username.length()));
              }
            })
            // 根据Person对象，获取age值
            .map(new Function<Person, Integer>() {
              @Override
              public Integer apply(Person person) throws Exception {
                return person.age;
              }
            })
            // 过滤得到age大于4的Person
            .filter(new Predicate<Integer>() {
              @Override
              public boolean test(Integer integer) throws Exception {
                return integer.intValue() > 4;
              }
            })
            // 从结果中获取1个对象
            .take(1)
            // 在每次输出一个元素之前做一些额外的事情，比如保存数据
            .doOnNext(new Consumer<Integer>() {
              @Override
              public void accept(Integer integer) throws Exception {
                // TODO
              }
            })
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Consumer<Integer>() {
              @Override
              public void accept(Integer age) throws Exception {
                System.out.println(TAG + "age is: " + age);
              }
            });
  }

  private void test3() {
    Observable<String> observable = Observable.fromArray("Hello", "World", "!");
    Observer<String> observer = new Observer<String>() {
      @Override
      public void onSubscribe(Disposable d) {

      }

      @Override
      public void onNext(String s) {
        System.out.println(TAG + s);
      }

      @Override
      public void onError(Throwable e) {

      }

      @Override
      public void onComplete() {

      }
    };

    observable.subscribe(observer);
  }

  private void test2() {
    Observable<String> observable = Observable.just("Hello World");
    Observer<String> observer = new Observer<String>() {
      @Override
      public void onSubscribe(Disposable d) {

      }

      @Override
      public void onNext(String s) {
        System.out.println(TAG + s);
      }

      @Override
      public void onError(Throwable e) {

      }

      @Override
      public void onComplete() {

      }
    };
    observable.subscribe(observer);
  }

  private void test1() {
    Observable<String> observable = new Observable<String>() {
      @Override
      protected void subscribeActual(Observer<? super String> observer) {
        observer.onNext("Hello");
        observer.onComplete();
      }
    };

    Observer<String> observer = new Observer<String>() {
      @Override
      public void onSubscribe(Disposable d) {

      }

      @Override
      public void onNext(String s) {
        System.out.println(TAG + s);
      }

      @Override
      public void onError(Throwable e) {

      }

      @Override
      public void onComplete() {

      }
    };

    observable.subscribe(observer);
  }
}
