package com.firstquad.sandbox.concurrency.callable;

import java.util.concurrent.Callable;

/**
 * Created by dmitriy on 16.04.17.
 */
public class Sum implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 5 + 5;
    }
}
