import java.util.Random;

public class Main {
    static EggVoice mAnotherOpinion;

    public static void main(String[] args) {
//        mAnotherOpinion = new EggVoice();
//        System.out.println("Початок суперечки...");
//        mAnotherOpinion.start();
//        for(int i = 0; i < 5; i++)
//        {
//            try{
//                Thread.sleep(1000);
//            }catch(InterruptedException e){}
//            System.out.println("курка!");
//        }
//        if(mAnotherOpinion.isAlive())
//        {
//            try{
//                mAnotherOpinion.join();
//            }catch(InterruptedException e){}
//            System.out.println("Першим було яйце!");
//        }
//        else
//        {
//            System.out.println("Першою була курка!");
//        }
//        System.out.println("Завершення суперечки!");
//
//
//        try{
//            Thread.sleep(1000);
//        }catch(InterruptedException e){}
//        System.out.println();
        System.out.println("Симуляція роботи ресторану");

        String[] tables = {"Стіл 1", "Стіл 2", "Стіл 3"};
        Random random = new Random();
        for (String table : tables) {
            Waiter waiter = new Waiter(table);
            Thread thread = new Thread(waiter);

            thread.start();
            if(random.nextBoolean()){
                try {
                    System.out.println( table + " запропонував чайові");
                    thread.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
