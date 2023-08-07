package io.turntabl.JavaMultithreading;

public class UnsafeThread implements Runnable {
    private int count;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            processSomething();
        }
    }

    public int getCount() {
        return this.count;
    }

    private void processSomething() {
        try {
            Thread.sleep(100);
            count++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

