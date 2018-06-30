package com.firstquad.sandbox.concurrency.synchronizing;

/**
 * Created by DVFirstov.SBT@sberbank.ru
 */
public class MyThread implements Runnable {
    private String name;
    private Shared sharedSynch;

    public MyThread(Shared sharedSynch) {
        this.sharedSynch = sharedSynch;
        this.name = "Thread:" + hashCode() + " ";
        new Thread(this).start();
    }

    @Override
    public void run() {
        synchronized (sharedSynch) {
            try {
                for (int i = 0; i < 5; i++) {
                    sharedSynch.increment();
                    Thread.sleep(100);
                    System.out.println(sharedSynch.getValue());
                    sharedSynch.decrement();
                    Thread.sleep(100);
                    System.out.println(sharedSynch.getValue());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
