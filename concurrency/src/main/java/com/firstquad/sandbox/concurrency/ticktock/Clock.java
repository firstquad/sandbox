package com.firstquad.sandbox.concurrency.ticktock;

/**
 * Created by dmitriy on 15.04.17.
 */
public class Clock {

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