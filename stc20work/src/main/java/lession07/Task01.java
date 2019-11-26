package lession07;

import java.util.Random;

/**
 * Для данного примера использовать рекурсию - не очень хороший вариант, т.к. происходит большое выделение памяти,
 * очень вероятен StackOverFlow. Лучше перемножать числа в простом цикле при этом создавать объект типа BigInteger
 */
public class Task01 {
    /**
     * Generate random
     */
    public int getRandomNumber(int bound) {
        Random rnd = new Random();
        return rnd.nextInt(bound);
    }

    /**
     * calc factorial
     * @param n bounds
     * @return result
     */
    public Long calculateFactorial(int n){
        Long result = 1L;
        for (int i = 1; i <=n; i ++){
            result = result*i;
        }
        return result;
    }
}
