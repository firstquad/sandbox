package com.firstquad.sandbox.concurrency.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by dmitriy on 16.04.17.
 */
public class StringUser implements Runnable {
    Exchanger<String> exchanger = new Exchanger<>();

    public StringUser(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        new Thread(this).start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(exchanger.exchange(new String()));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
