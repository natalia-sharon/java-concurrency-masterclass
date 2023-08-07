package io.turntabl.JavaMultithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class SafeThread implements Runnable {
    private final AtomicInteger atomicCounter = new AtomicInteger();

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            processSomething();
        }
    }

    public int getCount() {
        return this.atomicCounter.get();
    }

    private void processSomething() {
        try {
            Thread.sleep(100);
            atomicCounter.incrementAndGet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}