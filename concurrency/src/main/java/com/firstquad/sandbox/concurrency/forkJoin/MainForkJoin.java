package com.firstquad.sandbox.concurrency.forkJoin;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by dmitriy on 29.04.17.
 */
public class MainForkJoin {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        //async
        pool.execute(new MyAction("action 1"));

        try {
            while (pool.getActiveThreadCount() != 0) {
                Thread.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //sync
        Object invoke = pool.invoke(new MyTask("tack 1"));

        System.out.println("sqrt" + invoke);
    }
}
