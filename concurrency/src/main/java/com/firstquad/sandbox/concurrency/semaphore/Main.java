package com.firstquad.sandbox.concurrency.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by dmitriy on 15.04.17.
 */
public class Main {


    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
        new IncThread(semaphore);
        new DecThread(semaphore);
    }


}
