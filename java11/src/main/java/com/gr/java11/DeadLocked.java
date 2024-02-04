package com.gr.java11;

import java.io.IOException;

public class DeadLocked {

    private static class LockedUpThread extends Thread {
        Object l1;
        Object l2;

        public void init(Object lock1, Object lock2) {
            l1 = lock1;
            l2 = lock2;
        }

        public void run() {
            while (true) {
                synchronized (l1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (l2) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Got one!");
                    }
                }
            }
        }

    }

    public static void main(String[] args) throws IOException {

        Object lock1 = new Object();
        Object lock2 = new Object();

        LockedUpThread first = new LockedUpThread();
        LockedUpThread second = new LockedUpThread();
        first.setDaemon(true);
        second.setDaemon(true);

        //see the sequence.
        first.init(lock1, lock2);
        second.init(lock2, lock1);

        first.start();
        second.start();

        System.out.print("Press enter to quit!");
        System.out.flush();
        System.in.read();
    }
}
