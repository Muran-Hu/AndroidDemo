package com.droid.java.designpattern.ProducerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock, Condition, singleAll() 实现
 */
public class Tester2 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition producerCondition = lock.newCondition();
        Condition consumerCondition = lock.newCondition();

        Resource2 resource = new Resource2(lock, producerCondition, consumerCondition);

        Producer2 p1 = new Producer2(resource);

        Consumer2 c1 = new Consumer2(resource);
        Consumer2 c2 = new Consumer2(resource);
        Consumer2 c3 = new Consumer2(resource);

        p1.start();

        c1.start();
        c2.start();
        c3.start();
    }
}

/**
 * 公共资源类 - 用来存放事件
 */
class Resource2 {
    private int num = 0;
    private int size = 10;
    private Lock lock;
    private Condition producerCondition;
    private Condition consumerCondition;

    public Resource2(Lock lock, Condition producerCondition, Condition consumerCondition) {
        this.lock = lock;
        this.producerCondition = producerCondition;
        this.consumerCondition = consumerCondition;
    }

    public void add() {
        lock.lock();
        try {
            if (num < size) {
                num++;
                consumerCondition.signalAll();
                System.out.println("生产了一个事件，当前数量：" + num);
            } else {
                try {
                    producerCondition.await();
                    System.out.println("生产者进入阻塞状态");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void remove() {
        lock.lock();
        try {
            if (num > 0) {
                num--;
                producerCondition.signalAll();
                System.out.println("消费了一个事件，当前数量：" + num);
            } else {
                try {
                    consumerCondition.await();
                    System.out.println("消费者进入阻塞状态");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }
}

class Producer2 extends Thread {
    Resource2 resource;

    Producer2(Resource2 resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (resource != null) {
                resource.add();
            }
        }
    }
}

class Consumer2 extends Thread {
    Resource2 resource;

    Consumer2(Resource2 resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep((long) (1000 * Math.random()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (resource != null) {
                resource.remove();
            }
        }
    }
}

