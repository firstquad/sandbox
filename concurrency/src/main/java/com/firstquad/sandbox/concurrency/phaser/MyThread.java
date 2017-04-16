package com.firstquad.sandbox.concurrency.phaser;

import java.util.concurrent.Phaser;

/**
 * Created by dmitriy on 16.04.17.
 */
public class MyThread implements Runnable {
    Phaser phaser;
    String name;

    public MyThread(Phaser phaser, String name) {
        this.phaser = phaser;
        this.phaser.register();
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " done phase: 0");
            phaser.arriveAndAwaitAdvance();

            Thread.sleep(10);

            System.out.println(name + " done phase: 1");
            phaser.arriveAndAwaitAdvance();

            Thread.sleep(10);

            System.out.println(name + " done phase: 2");
            phaser.arriveAndAwaitAdvance();

            Thread.sleep(10);

            phaser.arriveAndDeregister();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
