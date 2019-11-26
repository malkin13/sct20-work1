package lession07;

/**
 * with Threads
 */
public class Threads implements Runnable {

    Task01 lession07task01 = new Task01();

    @Override
    public void run() {
        int rnd = lession07task01.getRandomNumber(40);
       // System.out.println("rnd - "+ rnd);

        Long factorial = lession07task01.calculateFactorial(rnd);
        System.out.println("factorial - "+factorial);
    }
}
