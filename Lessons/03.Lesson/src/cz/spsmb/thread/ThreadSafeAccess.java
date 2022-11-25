package cz.spsmb.thread;

public class ThreadSafeAccess extends Thread {

    private static int COUNT = 0;

    @Override
    public void run() { // pretizeni metody run(), která se bude vykonávat
        for(int i = 0; i < 5_000_000; i++) {
            synchronized (ThreadSafeAccess.class) {
                COUNT = COUNT + 1;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thr1 = new ThreadSafeAccess();
        Thread thr2 = new ThreadSafeAccess();
        Thread thr3 = new ThreadSafeAccess();

        thr1.start();
        thr2.start();
        thr3.start();

        thr1.join();
        thr2.join();
        thr3.join();

        System.out.println(COUNT); // Nyní k souběhu nedojde, protože před prací s proměnou COUNT
        // si tuto proměnou vlánko uzamkne pomocí příkazu synchronized. Tento příkaz funguje jako LOCK/MUTEX
        // Pokračuj na SemaphoreExample ;)
    }
}
