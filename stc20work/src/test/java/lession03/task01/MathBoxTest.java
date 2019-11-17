package lession03.task01;

import org.junit.Test;

import java.util.Random;

public class MathBoxTest {

    private static final int SIZE = 5;
    private MathBox mathBox;




    public void TestOne() {

        for (int i = 0; i < SIZE ; i++) {
            mathBox = new MathBox(getRandom(SIZE,8));
            System.out.println(mathBox);
           //mathBox = new MathBox();
            //);
        }
        System.out.println(getRandom(SIZE,8));



     //  System.out.println(mathBox);

    }

}
