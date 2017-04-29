package com.firstquad.sandbox.concurrency.forkJoin;

import java.util.concurrent.RecursiveTask;

/**
 * Created by dmitriy on 29.04.17.
 */
public class MyTask extends RecursiveTask {
    private String name;

    public MyTask(String name) {
        this.name = name;
    }

    @Override
    protected Object compute() {
        int count = Shared.count.getAndIncrement();
        System.out.println(name + " " + count);
        if (Shared.count.get() < 20)
            invokeAll(new MyTask("tack 2"), new MyTask("tack 3"));
        return Math.pow(count, 2);
    }
}
