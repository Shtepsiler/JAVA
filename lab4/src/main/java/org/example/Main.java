package org.example;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private static final ReentrantLock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static Counter counter = new Counter();
    private static final int ITERATIONS = 10;

    public static void main(String[] args) {
        Thread t1 = new Thread(new IncrementTask2());
        Thread t2 = new Thread(new IncrementTask2());

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static class IncrementTask implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < ITERATIONS; i++) {
                try {
                    if (lock.tryLock(300, TimeUnit.MILLISECONDS)) {
                        try {
                            counter.increment();
                            System.out.println(Thread.currentThread().getName() + " - Counter value after increment: " + counter.value());
                            condition.signal();
                        } finally {
                            lock.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " - Could not acquire lock");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class IncrementTask2 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < ITERATIONS; i++) {
                lock.lock();
                try {
                    counter.increment();
                    System.out.println(Thread.currentThread().getName() + " - Counter value after increment: " + counter.value());
                    condition.signal();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
