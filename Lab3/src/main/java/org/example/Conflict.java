package org.example;

public class Conflict  implements Runnable{
    private final String name;
    private Conflict bower;
    public Conflict (String name){
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public void setBower(Conflict bower){
        this.bower = bower;
    }
    public synchronized void bow() {
        System.out.format("%s: %s"
                        + " пропускає мене!%n",
                this.name, this.bower.getName());
        this.bower.bowBack(this);
    }
    public synchronized void bowBack(Conflict bower) {
        System.out.format("%s: %s"
                        + " пропускає мене у відповідь!%n",
                this.name, bower.getName());
    }

    @Override
    public void run() {
        bow();
    }
}
