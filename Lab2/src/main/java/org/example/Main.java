package org.example;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        // Створюємо синхронізований і не синхронізований лічильники
        Counter nonSynchronizedCounter = new Counter();
        SynchronizedCounter synchronizedCounter = new SynchronizedCounter();


        Scanner scanner = new Scanner(System.in);
        int n;

        System.out.println("Введіть кількість ітерацій:");
        while (!scanner.hasNextInt()) {
            System.out.println("Будь ласка, введіть коректне ціле число:");
            scanner.next(); // пропустити некоректне введення
        }

        n = scanner.nextInt(); // зчитуємо ціле число
        System.out.println("Ви ввели: " + n);


        for(int i =0;i<n;i++) {
        // Запуск потоків для не синхронізованого лічильника
        Thread t1 = new Thread(() -> {
            try {
                nonSynchronizedCounter.increment();
                System.out.println("Thread 1 (не синхронізований): значення лічильника: " + nonSynchronizedCounter.value());
            } catch (InterruptedException e) {
            }
        }, "Потік 1");

        Thread t2 = new Thread(() -> {
            try {
                nonSynchronizedCounter.increment();
                System.out.println("Thread 2 (не синхронізований): значення лічильника: " + nonSynchronizedCounter.value());
            } catch (InterruptedException e) {
            }
        }, "Потік 2");

        // Запускаємо потоки

            t1.start();
            t2.start();

            t1.join();
            t2.join();
        }
        for(int i =0;i<n;i++) {
        // Те саме для синхронізованого лічильника
        Thread t3 = new Thread(() -> {
            try {
                synchronizedCounter.increment();
                System.out.println("Thread 3 (синхронізований): значення лічильника: " + synchronizedCounter.value());
            } catch (InterruptedException e) {

            }
        }, "Потік 3");

        Thread t4 = new Thread(() -> {
            try {
                synchronizedCounter.increment();
                System.out.println("Thread 4 (синхронізований): значення лічильника: " + synchronizedCounter.value());
            } catch (InterruptedException e) {
            }
        }, "Потік 4");

            // Запускаємо потоки
            t3.start();
            t4.start();

            t3.join();
            t4.join();
        }
        System.out.println();
        NonSynchronizedDoubleCounter nonSynchronizedDoubleCounter = new NonSynchronizedDoubleCounter();
        for(int j =0;j<n*9;j++) {
        Thread t5 = new Thread(() -> {
            try {
                    nonSynchronizedDoubleCounter.incrementC1();
                    System.out.println("Thread 5 (подвійний не синхронізований c1): значення лічильника c1: " + nonSynchronizedDoubleCounter.getC1());

            } catch (InterruptedException e) {
            }
        }, "Потік 5");

        Thread t6 = new Thread(() -> {
            try {
                    nonSynchronizedDoubleCounter.incrementC2();
                    System.out.println("Thread 6 (подвійний не синхронізований c2): значення лічильника c2: " + nonSynchronizedDoubleCounter.getC1());
            } catch (InterruptedException e) {
            }
        }, "Потік 6");

            t5.start();
            t6.start();

            t5.join();
            t6.join();

        }
        System.out.println();


        for(int j =0;j<n*9;j++) {

            Thread t7 = new Thread(() -> {
                try {
                    nonSynchronizedDoubleCounter.decrementC1();
                    System.out.println("Thread 7 (подвійний не синхронізований c1): значення лічильника c1: " + nonSynchronizedDoubleCounter.getC2());
                } catch (InterruptedException e) {
                }
            }, "Потік 7");

            Thread t8 = new Thread(() -> {
                try {
                    nonSynchronizedDoubleCounter.decrementC2();
                    System.out.println("Thread 8 (подвійний не синхронізований c2): значення лічильника c2: " + nonSynchronizedDoubleCounter.getC2());
                } catch (InterruptedException e) {
                }
            }, "Потік 8");

            t7.start();
            t8.start();

            t7.join();
            t8.join();
        }



        System.out.println();
        // Створюємо подвійний лічильник
        SynchronizedDoubleCounter synchronizedDoubleCounter = new SynchronizedDoubleCounter();
        for(int i =0;i<n;i++) {


        // Запуск потоків для лічильників c1 і c2
        Thread t9 = new Thread(() -> {
            try {
                synchronizedDoubleCounter.incrementC1();
                System.out.println("Thread  9 (подвійний синхронізований c1): значення лічильника c1: " + synchronizedDoubleCounter.valueC1());
            } catch (InterruptedException e) {
            }
        }, "Потік 9");

        Thread t10 = new Thread(() -> {
            try {
                synchronizedDoubleCounter.incrementC2();
                System.out.println("Thread 10 (подвійний синхронізований c2): значення лічильника c2: " + synchronizedDoubleCounter.valueC2());
            } catch (InterruptedException e) {
            }
        }, "Потік 10");


        t9.start();
        t10.start();

        t9.join();
        t10.join();

        }
        for(int i =0;i<n;i++) {

            Thread t11 = new Thread(() -> {
                try {
                    synchronizedDoubleCounter.decrementC1();
                    System.out.println("Thread 11 (подвійний синхронізований c1): значення лічильника c1: " + synchronizedDoubleCounter.valueC1());
                } catch (InterruptedException e) {
                }
            }, "Потік 11");

            Thread t12 = new Thread(() -> {
                try {
                    synchronizedDoubleCounter.decrementC2();
                    System.out.println("Thread 12 (подвійний синхронізований c2): значення лічильника c2: " + synchronizedDoubleCounter.valueC2());
                } catch (InterruptedException e) {
                }
            }, "Потік 12");

            t11.start();
            t12.start();

            t11.join();
            t12.join();
        }
    }
}
