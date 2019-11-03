package lession01.task01;

import java.io.IOException;

/**
 * Написать программу ”Hello, World!”.
 * В ходе выполнения программы она должна выбросить исключение и завершиться с ошибкой.
 */
public class Task01 {

    public static void main(String[] args) throws IOException {

        System.out.println("Task 01");
        System.out.println("Hello, World!");
        getCount(null);
        getArray();
        getThrow();

    }

    /**
     * method generate Npe
     * @param obj
     * @return String object
     */
    private static String getCount(Object obj) {
                 return obj.toString();
            }

    /**
     * method generate Npe
     */
    private static void getArray() {
        int[] arr = {2, 3, 5, 22, 34};
        System.out.println(arr[6]);
    }

    /**
     * crazy amazing method generate IOException
     * @throws IOException
     */
    private static void getThrow() throws IOException {
        if(null == null){
            throw new IOException("Такие дела...");
        }
    }

}
