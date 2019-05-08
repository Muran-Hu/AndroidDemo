package com.droid.java.designpattern.ProducerConsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * BlockingQueue 实现
 */
public class Tester3 {
    public static void main(String[] args) {
        Resource3 resource = new Resource3();

        Producer3 p1 = new Producer3(resource);

        Consumer3 c1 = new Consumer3(resource);
        Consumer3 c2 = new Consumer3(resource);
        Consumer3 c3 = new Consumer3(resource);

        p1.start();

        c1.start();
        c2.start();
        c3.start();
    }
}

/**
 * 公共资源类 - 用来存放事件
 */
class Resource3 {
    private BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(10);

    public void add() {
        try {
            blockingQueue.put(1);
            System.out.println("生产了一个事件，当前数量：" + blockingQueue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void remove() {
        try {
            blockingQueue.take();
            System.out.println("消费了一个事件，当前数量：" + blockingQueue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 生产者
 */
class Producer3 extends Thread {
    Resource3 resource;

    Producer3(Resource3 resource) {
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

/**
 * 消费者
 */
class Consumer3 extends Thread {
    Resource3 resource;

    Consumer3(Resource3 resource) {
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
