package com.firstquad.sandbox.concurrency.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * Created by dmitriy on 15.04.17.
 */
public class Main {

    public static void main(String[] args) {

        BarrierService barrierAction = new BarrierService();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, barrierAction);
        new MyThread(cyclicBarrier, "A");
        new MyThread(cyclicBarrier, "B");
        new MyThread(cyclicBarrier, "C");

    }
}
