package lession03.task01;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class MathBoxTest {

    @Test
    public void TestOne() {
            Number[] numbers = {1, 2, 3, 4, 4, 4, 5, 6};

            MathBox mathBox = new MathBox(numbers);

            Assert.assertEquals("The number equals", 21, mathBox.summator());
            //System.out.println(mathBox);


            mathBox.splitter(3);
           // Assert.assertEquals("The number equals", "MathBox{numbers=[0, 1, 2]}", mathBox);
            System.out.println(mathBox);
            //mathBox.remove(2);
           // System.out.println(mathBox);
         //   mathBox.remove(3);
          //  System.out.println(mathBox);
    }

}
