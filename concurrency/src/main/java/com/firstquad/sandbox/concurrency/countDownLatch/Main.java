package com.firstquad.sandbox.concurrency.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 * Created by dmitriy on 15.04.17.
 */
public class Main {

    public static void main(String[] args) {
        CountDownLatch downLatch = new CountDownLatch(5);
        new MyThreadB(downLatch);
        new MyThreadA(downLatch);
    }
}
