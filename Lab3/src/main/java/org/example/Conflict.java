package org.example;

public class Conflict implements Runnable {
    private final String departmentName;  // Ім'я відділу
    private Conflict partnerDepartment;   // Відділ-партнер

    public Conflict(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return this.departmentName;
    }

    public void setPartnerDepartment(Conflict partnerDepartment) {
        this.partnerDepartment = partnerDepartment;
    }

    public synchronized void negotiate() {
        System.out.format("%s: Чекає рішення від відділу %s...%n",
                this.departmentName, this.partnerDepartment.getDepartmentName());
        this.partnerDepartment.finalizeDecision(this);  // Перший відділ чекає на другий
    }

    public synchronized void finalizeDecision(Conflict partner) {
        try {
            // Додаємо затримку, щоб симулювати затримку ухвалення рішення
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.format("%s: Отримав рішення від відділу %s. Можна рухатися далі.%n",
                this.departmentName, partner.getDepartmentName());
    }

    @Override
    public void run() {
        negotiate();
    }
}
