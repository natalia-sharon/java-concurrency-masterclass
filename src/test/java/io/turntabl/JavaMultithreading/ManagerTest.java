package io.turntabl.JavaMultithreading;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ManagerTest {

    private Manager manager;

    /**
     * These tests spawn the different ways in which we can create threads
     */

    @BeforeAll
    public void init() {
        manager = new Manager();
    }

    @Test
    public void processorTest() {
        manager.startProcessorThreads();
    }

    @Test
    public void runnableProcessorTest() {
        manager.startRunnableThreads();
    }

    @Test
    public void executorTest() {
        manager.startCallableThreads();
    }

    @Test
    public void executorFutureTest() throws Exception {
        manager.startExecutorFuture();
    }

    @Test
    public void threadStateTest() throws InterruptedException {
        manager.threadStates();
    }

    @Test
    public void callableLambdaTest() throws Exception {
        manager.startExecutorCallableLambda();
    }
}
