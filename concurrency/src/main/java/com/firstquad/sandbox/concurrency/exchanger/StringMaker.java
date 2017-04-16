package com.firstquad.sandbox.concurrency.exchanger;

import java.util.concurrent.Exchanger;

/**
 * Created by dmitriy on 16.04.17.
 */
public class StringMaker implements Runnable {
    Exchanger<String> exchanger = new Exchanger<>();
    String string;

    public StringMaker(Exchanger<String> exchanger) {
        this.exchanger = exchanger;
        this.string = new String();
        new Thread(this).start();
    }

    @Override
    public void run() {
        char c = 'a';
        for (int i = 0; i < 5; i++) {
            try {
                string = exchanger.exchange(string);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            string += c++;
        }
    }
}
