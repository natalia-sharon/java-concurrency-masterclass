package io.turntabl.JavaMultithreading;

import java.util.concurrent.*;

public class Manager {

    public void startProcessorThreads() {
        Processor thread = new Processor();
        thread.start();
        System.out.println("Manager - Current thread name: " + thread.getName());
    }

    public void startRunnableThreads() {
        RunnableProcessor runnable = new RunnableProcessor();
        Thread thread = new Thread(runnable);
        thread.start();
        System.out.println("Manager - Current thread name: " + Thread.currentThread().getName());
    }

    public void startCallableThreads() {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        CallableProcessor callable = new CallableProcessor();
        executor.submit(callable);
        System.out.println("Manager - Current thread name: " + Thread.currentThread().getName());
    }

    public void startExecutorFuture() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        CallableProcessor callable = new CallableProcessor();

        Future<String> future1 = executor.submit(callable);
        Future<String> future2 = executor.submit(callable);

        while (!(future1.isDone() && future2.isDone())) {
            System.out.println("future 1 is" + (future1.isDone() ? "done" : "not done"));
            System.out.println("future 2 is" + (future2.isDone() ? "done" : "not done"));

            Thread.sleep(300);
        }

        System.out.println(future1.get() + " and " + future2.get());
        executor.shutdown();
    }

    public void threadStates() throws InterruptedException {
        Thread thread = new Thread(new RunnableProcessor());
        System.out.println(thread.getState());

        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.getState());

        Thread.sleep(1000);
        System.out.println(thread.getState());
    }

    public void startExecutorCallableLambda() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Callable<String> callable = () -> {
            // Perform some computation
            System.out.println("Entered Callable");
            return "Hello I am Callable";
        };

        Future<String> future = executor.submit(callable);

        System.out.println(future.get());
    }
}
