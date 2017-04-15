package com.firstquad.sandbox.concurrency.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by dmitriy on 15.04.17.
 */
public class IncThread implements Runnable {
    private String name = "inc";

    private Semaphore semaphore;

    public IncThread(Semaphore semaphore) {
        this.semaphore = semaphore;
        new Thread(this).start();
    }

    @Override
    public void run() {
        try {
            System.out.println(name + " wait");
            semaphore.acquire();
            System.out.println(name + " acquire");

            for (int i = 0; i < 5; i++) {
                SharedResource.count++;
                System.out.println(SharedResource.count);
                Thread.sleep(100);
            }

            System.out.println(name + " release");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
