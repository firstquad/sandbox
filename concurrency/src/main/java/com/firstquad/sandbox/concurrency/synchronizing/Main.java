package com.firstquad.sandbox.concurrency.synchronizing;

/**
 * Created by DVFirstov.SBT@sberbank.ru
 */
public class Main {

    public static void main(String[] args) {
        SharedSynch sharedSynch = new SharedSynch();
        new MyThread(sharedSynch);
        new MyThread(sharedSynch);
    }
}
