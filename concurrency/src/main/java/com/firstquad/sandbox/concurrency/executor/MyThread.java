package com.firstquad.sandbox.concurrency.executor;

import java.util.concurrent.CountDownLatch;

/**
 * Created by dmitriy on 16.04.17.
 */
public class MyThread implements Runnable {
    CountDownLatch countDownLatch;
    String name;

    public MyThread(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
        new Thread(this);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            countDownLatch.countDown();
            System.out.println(name + " " + i);
        }
    }
}
