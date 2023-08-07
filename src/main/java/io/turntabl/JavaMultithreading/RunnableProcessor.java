package io.turntabl.JavaMultithreading;

public class RunnableProcessor implements Runnable {
    @Override
    public void run() {
        System.out.println("Runnable Processor - Current thread name: " + Thread.currentThread().getName());
    }
}