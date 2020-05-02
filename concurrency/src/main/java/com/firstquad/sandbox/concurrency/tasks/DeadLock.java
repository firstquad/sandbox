package com.firstquad.sandbox.concurrency.tasks;

public class DeadLock {
    private Object left = new Object();
    private Object right = new Object();

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();

        new Thread(() -> deadLock.left()).start();
        new Thread(() -> deadLock.right()).start();
    }

    public void left() {
        for (int i = 0; i < 100; i++) {
            synchronized (left) {
                synchronized (right) {
                    System.out.println("left first" + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public void right() {
        for (int i = 0; i < 100; i++) {
            synchronized (right) {
                synchronized (left) {
                    System.out.println("right first " + i);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
