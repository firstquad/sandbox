package com.firstquad.sandbox.concurrency.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by dmitriy on 15.04.17.
 */
public class MyThreadB implements Runnable {
    CountDownLatch downLatch;

    public MyThreadB(CountDownLatch downLatch) {
        this.downLatch = downLatch;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            System.out.println("B wait");
            downLatch.await();
            System.out.println("B release");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
