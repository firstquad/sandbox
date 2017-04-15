package com.firstquad.sandbox.concurrency.ticktock;

/**
 * Created by dmitriy on 15.04.17.
 */
public class MyThread implements Runnable {
    Thread thread;
    Clock clock;

    public MyThread(Clock clock, String name) {
        this.thread = new Thread(this, name);
        this.clock = clock;
        thread.start();

    }

    @Override
    public void run() {
        String tick = "Tick";
        String tock = "Tock";
        if (thread.getName().equals(tick)) {
            for (int i = 0; i < 5; i++) {
                clock.doAction(true, tick);
            }
            clock.doAction(false, tock);
        } else {
            for (int i = 0; i < 5; i++) {
                clock.doAction(true, tock);
            }
            clock.doAction(false, tick);
        }
    }
}
