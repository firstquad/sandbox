package com.firstquad.sandbox.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by dmitriy on 17.04.17.
 */
public class Main {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();

        new MyThread(lock, "A");
        new MyThread(lock, "B");
    }
}
