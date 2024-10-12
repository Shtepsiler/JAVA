package org.example;

import java.util.Scanner;

public class Main {

    // Симуляція конфлікту між відділами компанії
    private static void conflictDepartments() {
        Conflict sales = new Conflict("Відділ Продажів");
        Conflict marketing = new Conflict("Відділ Маркетингу");
        sales.setPartnerDepartment(marketing);
        marketing.setPartnerDepartment(sales);

        Thread salesThread = new Thread(sales);
        Thread marketingThread = new Thread(marketing);

        salesThread.start();
        marketingThread.start();
    }

    // Симуляція вирішення конфлікту між відділами компанії
    private static void resolvedDepartments() {
        ResolvedConflict finance = new ResolvedConflict("Відділ Фінансів");
        ResolvedConflict legal = new ResolvedConflict("Юридичний Відділ");
        finance.setPartnerDepartment(legal);
        legal.setPartnerDepartment(finance);

        Thread financeThread = new Thread(finance);
        Thread legalThread = new Thread(legal);

        financeThread.start();
        legalThread.start();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Виберіть програму: 0 - симуляція конфлікту між відділами, 1 - вирішення конфлікту");
        int choice = scanner.nextInt();

        if (choice == 0) {
            conflictDepartments();  // Симуляція конфлікту між відділами
        } else {
            resolvedDepartments();  // Симуляція вирішення конфлікту
        }
    }
}
