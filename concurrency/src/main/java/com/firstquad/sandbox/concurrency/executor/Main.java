package com.firstquad.sandbox.concurrency.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by dmitriy on 16.04.17.
 */
public class Main {

    public static void main(String[] args) {
        CountDownLatch c1 = new CountDownLatch(5);
        CountDownLatch c2 = new CountDownLatch(5);
        CountDownLatch c3 = new CountDownLatch(5);
        CountDownLatch c4 = new CountDownLatch(5);

        ExecutorService ex = Executors.newFixedThreadPool(2);

        ex.execute(new MyThread(c1, "A"));
        ex.execute(new MyThread(c2, "B"));
        ex.execute(new MyThread(c3, "C"));
        ex.execute(new MyThread(c4, "D"));

        try {
            c1.await();
            c2.await();
            c3.await();
            c4.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ex.shutdown();
    }

}
