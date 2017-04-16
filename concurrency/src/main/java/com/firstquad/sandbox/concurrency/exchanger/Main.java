package com.firstquad.sandbox.concurrency.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by dmitriy on 16.04.17.
 */
public class Main {

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new StringMaker(exchanger);
        new StringUser(exchanger);
    }
}
