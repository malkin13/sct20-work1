package lession01.task02;

import java.util.Random;
import java.util.Scanner;

/**
 * Составить программу, генерирующую N случайных чисел. Для каждого числа k вычислить квадратный корень q.
 * Если квадрат целой части q числа равен k, то вывести это число на экран.
 * Предусмотреть что первоначальные числа могут быть отрицательные, в этом случае генерировать исключение.
 */
public class Task02 {

    public static void main(String[] args) throws Exception {

        System.out.println("Task 02");
        System.out.println("input N (generate random numbers ) = ");
        Scanner sc = new Scanner(System.in);
        String N = sc.nextLine();

        randomMagic(Integer.valueOf(N));
    }

    /**
     * method
     * @param length
     * @throws Exception
     */
    private static void randomMagic(int length) throws Exception {
        Integer startArray[] = new Integer[length];
        Double sqrArray[]= new Double[length];

        Random rnd = new Random();
        for( int i=0; i< length; i++){
            startArray[i] = rnd.nextInt(1000);
            System.out.println("elements - "+startArray[i]);
            if (startArray[i] < 0) {
                throw new Exception("в массиве есть отрицательные значения !");
            } else {
                sqrArray[i] =  squareRoot(startArray[i]);
                System.out.println(" sqrElements - "+sqrArray[i]);
            }

        }

    }

    /**
     * calculate Square Root method
     * @param squareElements
     * @return Square result
     */
    private static double squareRoot(int squareElements) {
      return Math.sqrt(squareElements);
    }
}
