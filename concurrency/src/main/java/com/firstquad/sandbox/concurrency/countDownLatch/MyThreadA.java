package com.firstquad.sandbox.concurrency.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by dmitriy on 15.04.17.
 */
public class MyThreadA implements Runnable {
    CountDownLatch downLatch;

    public MyThreadA(CountDownLatch downLatch) {
        this.downLatch = downLatch;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            downLatch.countDown();
            System.out.println("countDown: " + i);
        }
    }
}
