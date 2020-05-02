package com.firstquad.sandbox.concurrency.tasks.philosopher;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by DVFirstov.SBT@sberbank.ru
 */
public class Philosopher implements Runnable {
    private String name;
    private Fork leftFork;
    private final Fork rightFork;
    private AtomicInteger countOfDinner = new AtomicInteger(0);
    private AtomicBoolean isFull = new AtomicBoolean();

    public Philosopher(String name, Fork leftFork, Fork rightFork) {
        this.name = name;
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (Table.countOfFull.get() < 5) {
            System.out.println(this);

            if (countOfDinner.get() < 100 && leftFork.isUsing() && rightFork.isUsing()) {
                countOfDinner.incrementAndGet();
            }

            if (leftFork.getNextFork() != null) {
                leftFork.setIsUsing(false);
                Fork nextFork = leftFork.getNextFork();
                leftFork.setNextFork(null);
                nextFork.setIsUsing(true);
                rightFork.setNextFork(leftFork);
            }

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (!isFull.get() && countOfDinner.get() == 100) {
                Table.countOfFull.incrementAndGet();
                isFull.set(true);
            }
        }
        if (Table.countOfFull.get() == 5)
            System.out.println(this);
    }

    @Override
    public String toString() {
        return name + " is " + "eating " + countOfDinner.get() + " times";
    }
}
