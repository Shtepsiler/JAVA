package org.example;

public class ResolvedConflict implements Runnable{
    private final String name;
    private ResolvedConflict bower;
    private static boolean check = true;
    public ResolvedConflict (String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

    public void setBower(ResolvedConflict bower){
        this.bower = bower;
    }

    public synchronized void bow() {
        try {
            while (!check) {
                wait();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        check = false;
        notifyAll();
        System.out.format("%s: %s"
                        + " пропускає мене!%n",
                this.name, this.bower.getName());
        this.bower.bowBack(this);
    }
    public synchronized void bowBack(ResolvedConflict bower) {
        System.out.format("%s: %s"
                        + " пропускає мене у відповідь!%n",
                this.name, bower.getName());
        check = true;
        notifyAll();
    }

    @Override
    public void run() {
        bow();
    }
}
