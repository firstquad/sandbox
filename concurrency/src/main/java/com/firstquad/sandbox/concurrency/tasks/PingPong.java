package com.firstquad.sandbox.concurrency.tasks;

public class PingPong {

    public static void main(String[] args) {
        Action action = new Action();
        new Thread(action, "ping").start();
        new Thread(action, "pong").start();
    }

    public static class Action implements Runnable {
        @Override
        public synchronized void run() {
            int i = 0;
            while (i < 10) {
                i++;
                System.out.println(Thread.currentThread().getName());
                notifyAll();
                try {
                    if (i < 10) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
