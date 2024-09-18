package org.example;

import java.util.Scanner;
public class Main {
    private static void conflictBowers(){
        Conflict first = new Conflict("Потік 1");
        Conflict second = new Conflict("Потік 2");
        first.setBower(second);
        second.setBower(first);

        Thread firstThread = new Thread(first);
        Thread secondThread = new Thread(second);

        firstThread.start();
        secondThread.start();
    }
    private static void resolvedBowers(){
        ResolvedConflict first = new ResolvedConflict("Потік 1");
        ResolvedConflict second = new ResolvedConflict("Потік 2");
        first.setBower(second);
        second.setBower(first);

        Thread firstThread = new Thread(first);
        Thread secondThread = new Thread(second);

        firstThread.start();
        secondThread.start();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Виберіть програму: 0 - з конфліктом, 1 - з вирішеним конфліктом");
        int choice = scanner.nextInt();

        if(choice == 0)
        {
            conflictBowers();
        }
        else {
            resolvedBowers();
        }


    }
}