package cz.spsmb.thread;

import java.util.concurrent.Semaphore;

/**
 * Zadání: Vytvořte program, který bude simulovat náštěvu prostoru PlayGround během práce.
 * V místnosti PlayGround může být max 5 lidí v jeden okamžit. Když je tam chce přijít další,
 * tak musí počkat, než se uvolní místo. Pro tento problém se hodí použít synchronizačního primitiva
 * semaphore. Níže je ukázka použití.
 */
public class SemaphoreExample {


    public static void main(String[] args) {
        for(int i = 0; i < 20; i++) {
            Person person = new Person(); //Inicializace vláken/zaměstnanců
            person.start();
        }
    }

    private static class Person extends Thread {

        private static Semaphore PLAYGROUND_ROOM = new Semaphore(5); // Inicializace semaphoru s kapacitou 5 lidi.

        private boolean isRunning;

        public Person() {
            this.isRunning = true;
        }

        @Override
        public void run() {
            while (isRunning) {
                try {
                    goToPlayGround();
                    doWork();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    isRunning = false;
                }
            }
        }

        private void doWork() throws InterruptedException {
            System.out.println(this.getName() + ": I am working really hard!");
            Thread.sleep(5000);
        }

        private void goToPlayGround() throws InterruptedException {
            PLAYGROUND_ROOM.acquire(); // Zvysi pocet lidi v mistnosti. Pokud byla dosazena max. kapacita, tak se zde kod zastavi a ceka.
            System.out.println(this.getName() + ": I am having good time!!");
            Thread.sleep(1000);
            PLAYGROUND_ROOM.release(); // Uvolni zamek. Uzivatel odesel a nyni tam muze jít další.
        }
    }
}
