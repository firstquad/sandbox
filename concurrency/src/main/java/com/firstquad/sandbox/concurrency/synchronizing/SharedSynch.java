package com.firstquad.sandbox.concurrency.synchronizing;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dmitriy on 17.04.17.
 */
public class SharedSynch implements Shared {
    public Integer count = 0;
    private Lock lock = new ReentrantLock();

    public SharedSynch() {
    }

    @Override
    public void increment() {
//        lock.lock();
        count++;
    }

    @Override
    public void decrement() {
        count--;
//        lock.unlock();
    }

    @Override
    public synchronized int getValue() {
        return count;
    }

    @Override
    public synchronized void loop() {
        try {
            for (int i = 0; i < 5; i++) {
                count++;
                Thread.sleep(100);
                System.out.println(count);
                count--;
                Thread.sleep(100);
                System.out.println(count);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}