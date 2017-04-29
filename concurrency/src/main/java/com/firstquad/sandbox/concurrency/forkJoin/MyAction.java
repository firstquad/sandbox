package com.firstquad.sandbox.concurrency.forkJoin;

import java.util.concurrent.RecursiveAction;

/**
 * Created by dmitriy on 29.04.17.
 */
public class MyAction extends RecursiveAction {
    private String name;

    public MyAction(String name) {
        this.name = name;
    }

    @Override
    protected synchronized void compute() {
        System.out.println(name + " " + Shared.count.getAndIncrement());

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (Shared.count.get() < 10)
            invokeAll(new MyAction("action 2"), new MyAction("action 3"));
    }
}
