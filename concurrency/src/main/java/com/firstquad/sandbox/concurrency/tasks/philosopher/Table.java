package com.firstquad.sandbox.concurrency.tasks.philosopher;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by DVFirstov.SBT@sberbank.ru
 */
public class Table implements Runnable {
    public static AtomicInteger countOfFull = new AtomicInteger(0);

    public static void main(String[] args) {
        new Table().run();
    }

    @Override
    public void run() {
        Fork fork1 = new Fork(false);
        Fork fork2 = new Fork(true);
        Fork fork3 = new Fork(true);
        Fork fork4 = new Fork(true);
        Fork fork5 = new Fork(true, fork1);

        new Philosopher("Sokrat", fork2, fork1);
        new Philosopher("Demokrit", fork3, fork2);
        new Philosopher("Epikyr", fork4, fork3);
        new Philosopher("Platon", fork5, fork4);
        new Philosopher("Evklid", fork1, fork5);
    }

}
