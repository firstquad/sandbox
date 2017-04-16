package com.firstquad.sandbox.concurrency.phaser;

import java.util.concurrent.Phaser;

/**
 * Created by dmitriy on 16.04.17.
 */
public class Main {

    public static void main(String[] args) {
        Phaser phaser = new Phaser(1);

        System.out.println("Starting");

        new MyThread(phaser, "A");
        new MyThread(phaser, "B");
        new MyThread(phaser, "C");

        int phaseNumber = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("done phase " + phaseNumber);

        phaseNumber = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("done phase " + phaseNumber);

        phaseNumber = phaser.getPhase();
        phaser.arriveAndAwaitAdvance();
        System.out.println("done phase " + phaseNumber);

        phaser.arriveAndDeregister();

        if (phaser.isTerminated())
            System.out.println("phaser done!");

    }
}
