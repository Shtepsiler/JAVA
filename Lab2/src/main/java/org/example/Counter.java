package org.example;
class Counter {
    private int c = 0;

    // Не синхронізовані методи
    public void increment() throws InterruptedException {
        int a;
        //System.out.println(Thread.currentThread().getName() + " викликає increment() без синхронізації");
        Thread.sleep(150); // Імітація затримки
        a = c;
       // System.out.println(Thread.currentThread().getName() + " прочитав c = " + a);
        a++;
        c = a;
      //  System.out.println(Thread.currentThread().getName() + " збільшив c до " + c);
    }

    public void decrement() throws InterruptedException {
        int a;
     //   System.out.println(Thread.currentThread().getName() + " викликає decrement() без синхронізації");
        Thread.sleep(100); // Імітація затримки
        a = c;
      //  System.out.println(Thread.currentThread().getName() + " прочитав c = " + a);
        a--;
        c = a;
      //  System.out.println(Thread.currentThread().getName() + " зменшив c до " + c);
    }

    public int value() {
        return c;
    }
}
