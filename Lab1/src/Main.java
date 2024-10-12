public class Main {
    static EggVoice eggVoice;
    static DinoVoice dinoVoice;

    public static void main(String[] args) throws InterruptedException {
        eggVoice = new EggVoice();
        dinoVoice = new DinoVoice();

        System.out.println("Початок суперечки...");

        eggVoice.start();
        dinoVoice.start();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.println("курка!");
        }

        if (!eggVoice.isAlive() && !dinoVoice.isAlive()) {
            System.out.println("Першим було курка!");
        } else if (eggVoice.isAlive()) {
            eggVoice.join();
            System.out.println("Першим було яйце!");
        } else if (dinoVoice.isAlive()) {
            dinoVoice.join();
            System.out.println("Першим був динозавр!");
        }

        System.out.println("Завершення суперечки!");
    }
}