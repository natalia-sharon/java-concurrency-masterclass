package io.turntabl.JavaMultithreading;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SafeThreadTest {

    private static final int COUNT_200 = 200;


    /**
     * These tests show different thread safety mechanisms
     */


    @Test
    public void counterTest() throws InterruptedException {
        UnsafeThread unsafe = new UnsafeThread();

        Thread t1 = new Thread(unsafe);
        Thread t2 = new Thread(unsafe);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Unsafe = " + unsafe.getCount());
        assertNotEquals(COUNT_200, unsafe.getCount());
    }

    @Test
    public void atomicCounterTest() throws InterruptedException {
        SafeThread safe = new SafeThread();

        Thread t1 = new Thread(safe);
        Thread t2 = new Thread(safe);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Safe = " + safe.getCount());
        assertEquals(COUNT_200, safe.getCount());
    }

    @Test
    public void synchronisedTest() throws InterruptedException {
        Synchronised sync = new Synchronised();

        Thread t1 = new Thread(sync);
        Thread t2 = new Thread(sync);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("Sync = " + sync.getCount());
        assertEquals(COUNT_200, sync.getCount());
    }

    @Test
    public void semaphoreTest() throws InterruptedException {
        SemaphoreExample sem = new SemaphoreExample();
        sem.startProcessorThreads();
    }
}
