package org.example;

public class SynchronizedCounter {
    private int c = 0;

    public synchronized void increment() throws InterruptedException {
        int a;
        Thread.sleep(0);
        a = c;
        a++;
        c = a;
    }

    public synchronized void decrement() throws InterruptedException {
        int a;
        Thread.sleep(200);
        a = c;
        a--;
        c = a;
    }

    public synchronized int value() {
        return c;
    }
}
