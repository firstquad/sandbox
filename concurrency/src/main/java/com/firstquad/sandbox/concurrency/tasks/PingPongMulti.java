package com.firstquad.sandbox.concurrency.tasks;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class PingPongMulti {

    private static final String pingName = "ping";
    private static final String pongName = "pong";
    private static final String pungName = "pung";
    private static final String pangName = "pang";

    public static void main(String[] args) {
        Action action = new Action();
        new Thread(action, pingName).start();
        new Thread(action, pongName).start();
        new Thread(action, pungName).start();
        new Thread(action, pangName).start();
    }

    public static class Action implements Runnable {
        private final static BlockingQueue<String> queue = new LinkedBlockingQueue<>(4);

        static {
            queue.add(pingName);
            queue.add(pongName);
            queue.add(pungName);
            queue.add(pangName);
        }

        @Override
        public synchronized void run() {
            int i = 0;
            while (i < 10) {
                i++;

                String threadName = Thread.currentThread().getName();
                while (!queue.peek().equalsIgnoreCase(threadName)) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.poll();

                System.out.println(threadName);

                try {
                    queue.put(threadName);
                    notifyAll();
                    if (i < 10) {
                        wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
