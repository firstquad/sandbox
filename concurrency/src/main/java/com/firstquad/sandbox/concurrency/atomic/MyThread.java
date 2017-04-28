package com.firstquad.sandbox.concurrency.atomic;

/**
 * Created by dmitriy on 18.04.17.
 */
public class MyThread implements Runnable {

    String name;

    public MyThread(String name) {
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + " " + Shared.count.getAndIncrement());
        }
    }
}
