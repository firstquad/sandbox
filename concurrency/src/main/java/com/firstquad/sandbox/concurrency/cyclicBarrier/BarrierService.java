package com.firstquad.sandbox.concurrency.cyclicBarrier;

/**
 * Created by dmitriy on 15.04.17.
 */
public class BarrierService implements Runnable {

    @Override
    public void run() {
        System.out.println("Barrier has reached!");
    }
}
