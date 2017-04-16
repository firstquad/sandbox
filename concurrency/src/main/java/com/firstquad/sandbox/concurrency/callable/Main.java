package com.firstquad.sandbox.concurrency.callable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Created by dmitriy on 16.04.17.
 */
public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Future<Integer> sum = executor.submit(new Sum());
        Future<Integer> diff = executor.submit(new Difference());

        try {
            int i = 0;

            Integer integer = null;

            while (integer == null) {
                try {
                    integer = sum.get(10L, TimeUnit.MILLISECONDS);
                } catch (Exception e) {
                    System.out.println(++i);
                }
            }

            System.out.println("\n\n");

            System.out.println(sum.get());
            System.out.println(diff.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
