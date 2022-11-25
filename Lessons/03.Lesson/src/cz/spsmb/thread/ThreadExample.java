package cz.spsmb.thread;

public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() { // Vytvoření nového vlákna
            @Override
            public void run() {
                //  Tento kod se bude vykonavat paralelně, až bude zavolana metoda .start();
                for(int i = 0; i < 10; i++) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000); // Uspani aktualniho vlakna na 1000ms
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start(); // ,,Zacni" vykonavat kod/nastartuj se
        thread.join(); // Toto hlavni vlakno bude cekat, dokud se kod v thread nevykona cely
        // thread.interrupt(); // Tato metoda probudi uspane vlakno
    }
}
