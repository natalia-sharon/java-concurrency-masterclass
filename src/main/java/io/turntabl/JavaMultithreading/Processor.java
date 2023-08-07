package io.turntabl.JavaMultithreading;

public class Processor extends Thread {

    @Override
    public void run() {
        System.out.println("Processor - Current thread name: " + Thread.currentThread().getName());
    }
}
