package lession07;

import org.junit.Test;

/**
 * Test class for testing Thread Factorial
 */
public class L07Task01Test {

    @Test
    public void FactorialTest() throws InterruptedException {
        System.out.println("---- start -----");

        Thread myThreads[] = new Thread[15];
        for (int j = 0; j < 15; j++) {
            myThreads[j] = new Thread(new Threads());
            myThreads[j].start();
        }
        for (int j = 0; j < 15; j++) {
            myThreads[j].join();
        }

        System.out.println("---- end -----");
    }

}
