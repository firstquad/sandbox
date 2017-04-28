package com.firstquad.sandbox.concurrency.atomic;

/**
 * Created by dmitriy on 18.04.17.
 */
public class Main {

    public static void main(String[] args) {
        new MyThread("A");
        new MyThread("B");
        new MyThread("C");
        new MyThread("D");
        new MyThread("E");
        new MyThread("F");
    }
}
