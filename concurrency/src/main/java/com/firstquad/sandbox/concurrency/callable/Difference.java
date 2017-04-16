package com.firstquad.sandbox.concurrency.callable;

import java.util.concurrent.Callable;

/**
 * Created by dmitriy on 16.04.17.
 */
public class Difference implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 5 - 2;
    }
}
