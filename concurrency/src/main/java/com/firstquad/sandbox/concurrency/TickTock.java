package com.firstquad.sandbox.concurrency;

/**
 * Created by dmitriy on 05.04.17.
 */
public class TickTock {

    public static void main(String[] args) {
        Clock clock = new Clock();
        MyThread myThread1 = new MyThread(clock, "Tick");
        MyThread myThread2 = new MyThread(clock, "Tock");

        try {
            myThread1.thread.join();
            myThread2.thread.join();
        } catch (InterruptedException e) {
            System.out.println("Прерывание основного потока");
        }
    }

}


class MyThread implements Runnable {
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

class Clock {

    String state = "";

    synchronized void doAction(boolean isRunning, String action) {
        if (!isRunning) {
            state = action;
            notifyAll();
            return;
        }

        System.out.println(action);

        state = action;

        notifyAll();

        try {
            long l = System.currentTimeMillis();
            while (state.equals(action) /*&& System.currentTimeMillis() - l < 500*/) {
                wait();
            }
        } catch (Exception e) {
            System.out.println("Прерывание потока");
        }
    }

}