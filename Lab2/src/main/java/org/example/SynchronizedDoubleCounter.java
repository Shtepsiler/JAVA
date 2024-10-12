package org.example;
class SynchronizedDoubleCounter {
    private int c1 = 0;
    private int c2 = 0;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void incrementC1() throws InterruptedException {
        synchronized (lock1) {
           // System.out.println(Thread.currentThread().getName() + " викликає synchronized block для c1");
            int a;
            Thread.sleep(200);
            a = c1;
         //   System.out.println(Thread.currentThread().getName() + " прочитав c1 = " + a);
            a++;
            c1 = a;
           // System.out.println(Thread.currentThread().getName() + " збільшив c1 до " + c1);
        }
    }

    public void decrementC1() throws InterruptedException {
        synchronized (lock1) {
         //   System.out.println(Thread.currentThread().getName() + " викликає synchronized block для c1");
            int a;
            Thread.sleep(200);
            a = c1;
         //   System.out.println(Thread.currentThread().getName() + " прочитав c1 = " + a);
            a--;
            c1 = a;
         //   System.out.println(Thread.currentThread().getName() + " зменшив c1 до " + c1);
        }
    }

    public void incrementC2() throws InterruptedException {
        synchronized (lock2) {
        //    System.out.println(Thread.currentThread().getName() + " викликає synchronized block для c2");
            int a;
            Thread.sleep(200);
            a = c2;
         //   System.out.println(Thread.currentThread().getName() + " прочитав c2 = " + a);
            a++;
            c2 = a;
          //  System.out.println(Thread.currentThread().getName() + " збільшив c2 до " + c2);
        }
    }

    public void decrementC2() throws InterruptedException {
        synchronized (lock2) {
        //    System.out.println(Thread.currentThread().getName() + " викликає synchronized block для c2");
            int a;
            Thread.sleep(200);
            a = c2;
//System.out.println(Thread.currentThread().getName() + " прочитав c2 = " + a);
            a--;
            c2 = a;
         //   System.out.println(Thread.currentThread().getName() + " зменшив c2 до " + c2);
        }
    }

    public int valueC1() {
        return c1;
    }

    public int valueC2() {
        return c2;
    }
}
