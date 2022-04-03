package com.firstquad.sandbox.concurrency.tasks.ticktock;

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
            while (state.equals(action)) {
                wait();
            }
        } catch (Exception e) {
            System.out.println("Прерывание потока");
        }
    }

}