package org.example;

public class NonSynchronizedDoubleCounter {
    private int c1 = 0;
    private int c2 = 0;

    public void incrementC1() throws InterruptedException {
       // System.out.println(Thread.currentThread().getName() + " викликає incrementC1");
        int a;
        Thread.sleep(123); // Імітація затримки
        a = c1;
       // System.out.println(Thread.currentThread().getName() + " прочитав c1 = " + a);
        a++;
        c1 = a;
       // System.out.println(Thread.currentThread().getName() + " збільшив c1 до " + c1);
    }

    public void decrementC1() throws InterruptedException {
      //  System.out.println(Thread.currentThread().getName() + " викликає decrementC1");
        int a;
        Thread.sleep(234); // Імітація затримки
        a = c1;
       // System.out.println(Thread.currentThread().getName() + " прочитав c1 = " + a);
        a--;
        c1 = a;
       // System.out.println(Thread.currentThread().getName() + " зменшив c1 до " + c1);
    }

    public void incrementC2() throws InterruptedException {
      //  System.out.println(Thread.currentThread().getName() + " викликає incrementC2");
        int a;
        Thread.sleep(345); // Імітація затримки
        a = c2;
     //   System.out.println(Thread.currentThread().getName() + " прочитав c2 = " + a);
        a++;
        c2 = a;
      //  System.out.println(Thread.currentThread().getName() + " збільшив c2 до " + c2);
    }

    public void decrementC2() throws InterruptedException {
      //  System.out.println(Thread.currentThread().getName() + " викликає decrementC2");
        int a;
        Thread.sleep(456); // Імітація затримки
        a = c2;
      //  System.out.println(Thread.currentThread().getName() + " прочитав c2 = " + a);
        a--;
        c2 = a;
      //  System.out.println(Thread.currentThread().getName() + " зменшив c2 до " + c2);
    }

    public int getC1() {
        return c1;
    }

    public int getC2() {
        return c2;
    }
}
