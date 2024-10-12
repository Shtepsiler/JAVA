package org.example;

public class ResolvedConflict implements Runnable {
    private final String departmentName;  // Ім'я відділу
    private ResolvedConflict partnerDepartment;   // Партнер-відділ
    private static boolean canProceed = true;     // Перемикач для управління черговістю дій

    public ResolvedConflict(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setPartnerDepartment(ResolvedConflict partnerDepartment) {
        this.partnerDepartment = partnerDepartment;
    }

    // Синхронізований метод для координації ухвалення рішень
    public synchronized void negotiate() {
        try {
            // Якщо інший відділ ще не готовий, чекаємо
            while (!canProceed) {
                wait();
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        // Блокуємо інший відділ для ухвалення рішення
        canProceed = false;
        notifyAll();  // Повідомляємо інші потоки

        System.out.format("%s: Погодив стратегію з відділом %s!%n",
                this.departmentName, this.partnerDepartment.getDepartmentName());

        this.partnerDepartment.confirmDecision(this);
    }

    // Підтвердження прийнятого рішення з боку партнера
    public synchronized void confirmDecision(ResolvedConflict partner) {
        System.out.format("%s: Підтвердив спільну стратегію з відділом %s!%n",
                this.departmentName, partner.getDepartmentName());

        // Розблоковуємо, дозволяючи інший відділ продовжити
        canProceed = true;
        notifyAll();
    }

    @Override
    public void run() {
        negotiate();
    }
}
