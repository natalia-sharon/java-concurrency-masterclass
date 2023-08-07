package io.turntabl.JavaMultithreading;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    public void startProcessorThreads() throws InterruptedException {
        Semaphore semaphore = new Semaphore(2);
        RunnableSemaphore runnable = new RunnableSemaphore((semaphore));

        Thread thread0 = new Thread(runnable);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();

        thread0.join();
        thread1.join();
        thread2.join();
        thread3.join();
    }

}

class RunnableSemaphore implements Runnable {
    private Semaphore semaphore;
    private int count;

    RunnableSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }


    @Override
    public void run() {
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " acquired");
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName() + " count " + count++);
            System.out.println(Thread.currentThread().getName() + " releasing");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}