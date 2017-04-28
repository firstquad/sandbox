package com.firstquad.sandbox.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by dmitriy on 18.04.17.
 */
public class Shared {
    //    public static Integer count = 0;
    public static AtomicInteger count = new AtomicInteger(0);
}
