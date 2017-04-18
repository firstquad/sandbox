package com.firstquad.sandbox.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dmitriy on 17.04.17.
 */
public class MyThread implements Runnable {
    String name;
    ReentrantLock lock;

    public MyThread(ReentrantLock lock, String name) {
        this.name = name;
        this.lock = lock;
        new Thread(this).start();
    }

    @Override
    public void run() {
        System.out.println("Start " + name);
        try {
            System.out.println(name + " wait");
            lock.lock();
            System.out.println(name + " lock");
            System.out.println(name + " count before " + Shared.count);
            Shared.count++;
            System.out.println(name + " count after " + Shared.count);
            System.out.println(name + " sleep");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
