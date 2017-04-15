package com.firstquad.sandbox.concurrency.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by dmitriy on 15.04.17.
 */
public class MyThread implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private String name;
    Thread thread;

    public MyThread(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        try {
            cyclicBarrier.await();
            System.out.println("start " + name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
