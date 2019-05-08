package com.droid.java.designpattern.ProducerConsumer;

/**
 * synchronized, wait, notifyAll() 实现
 */
public class Tester {
    public static void main(String[] args) {
        Resource resource = new Resource(); // 第一种实现方式：synchronized，wait，notifyAll()

        Producer p1 = new Producer(resource);
        Producer p2 = new Producer(resource);
        Producer p3 = new Producer(resource);

        Consumer consumer = new Consumer(resource);

        p1.start();
        p2.start();
        p3.start();

        consumer.start();
    }
}

/**
 * 公共资源类 - 用来存放事件
 */
class Resource {
    private int num = 0;
    private int size = 10;

    public synchronized void add() {
        if (num < size) {
            num ++;
            notifyAll();
            System.out.println("生产了一个事件，当前数量：" + num);
        } else {
            try {
                wait();
                System.out.println("生产者进入阻塞状态");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void remove() {
        if (num > 0) {
            num --;
            notifyAll();
            System.out.println("消费了一个事件，当前数量：" + num);
        } else {
            try {
                wait();
                System.out.println("消费者进入阻塞状态");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
 * 生产者
 */
class Producer extends Thread {
    Resource resource;

    Producer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (resource != null) {
                resource.add();
            }
        }
    }
}

/**
 * 消费者
 */
class Consumer extends Thread {
    Resource resource;

    Consumer(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (resource != null) {
                resource.remove();
            }
        }
    }
}
