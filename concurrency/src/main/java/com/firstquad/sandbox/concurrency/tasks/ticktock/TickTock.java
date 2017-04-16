package com.firstquad.sandbox.concurrency.tasks.ticktock;

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
