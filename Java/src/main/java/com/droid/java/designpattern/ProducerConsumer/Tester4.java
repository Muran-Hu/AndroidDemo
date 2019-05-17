package com.droid.java.designpattern.ProducerConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Tester4 {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition producerCondition = lock.newCondition();
        Condition consumerCondition = lock.newCondition();

        Resources resource = new Resources(lock, producerCondition, consumerCondition);

        Producers p1 = new Producers(resource);

        Consumers c1 = new Consumers(resource);
        Consumers c2 = new Consumers(resource);
        Consumers c3 = new Consumers(resource);

        p1.start();

        c1.start();
        c2.start();
        c3.start();

    }
}

class Resources {
    int num = 0;
    int size = 10;

    Lock lock = new ReentrantLock();
    Condition producerCondition = lock.newCondition();
    Condition consumerCondition = lock.newCondition();

    Resources(Lock lock, Condition producerCondition, Condition consumerCondition) {
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

class Producers extends Thread {
    Resources resource;

    Producers(Resources resource) {
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

class Consumers extends Thread {
    Resources resource;

    Consumers(Resources resource) {
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
