public class Waiter implements Runnable{
    private String tableName;

    public Waiter(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public void run() {
        System.out.println("Офіціант обслуговує стіл " + tableName);
        try {
            Thread.sleep(2000); // Імітація часу обслуговування
        } catch (InterruptedException e) {
        }
        System.out.println("Офіціант завершив обслуговування столу " + tableName);
    }
}
