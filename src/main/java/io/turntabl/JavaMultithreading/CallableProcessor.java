package io.turntabl.JavaMultithreading;

import java.util.concurrent.Callable;

public class CallableProcessor implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Callable Processor - Current thread name: " + Thread.currentThread().getName());
        Thread.sleep(300);
        return "Hello I'm Callable";
    }
}
