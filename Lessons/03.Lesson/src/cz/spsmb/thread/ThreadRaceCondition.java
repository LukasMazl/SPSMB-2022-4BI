package cz.spsmb.thread;

public class ThreadRaceCondition extends Thread { // Dalsi způsob vytvoreni vlakna

    private static int COUNT = 0;

    @Override
    public void run() { // pretizeni metody run(), která se bude vykonávat
        for(int i = 0; i < 5_000_000; i++) {
            COUNT = COUNT + 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thr1 = new ThreadRaceCondition();
        Thread thr2 = new ThreadRaceCondition();
        Thread thr3 = new ThreadRaceCondition();

        thr1.start();
        thr2.start();
        thr3.start();

        thr1.join();
        thr2.join();
        thr3.join();

        System.out.println(COUNT); // Pokud každé vlákno zvýší hodnotu COUNT o 5 000 000, tak by to nyni mělo vypsat
        // hodnotu 15 000 000. Ale ono ne :O Dochází k tzv. race condition (česky k souběhu). Pokud více vláken pracuje
        // se sdílenou proměnou, tak je nutné tuto proměnou synchonizovat => Jdi do ThreadSafeAccess.java
    }
}
