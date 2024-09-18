public class Table extends Thread{
    private Waiter waiter;

    public Table(Waiter waiter) {
        this.waiter = waiter;  // Initialize Waiter object
    }

    @Override
    public void run() {
       // waiter.getTableName();
        waiter.run();  // Call the run method of the waiter
    }

}
