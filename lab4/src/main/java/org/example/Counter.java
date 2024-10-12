package org.example;

class Counter {
    private int c = 0;

    public void increment() throws InterruptedException {
        int a;
        Thread.sleep(200);
        a = c;
        a++;
        c = a;
    }

    public void decrement() throws InterruptedException {
        int a;
        Thread.sleep(100);
        a = c;
        a--;
        c = a;
    }

    public int value() {
        return c;
    }
}