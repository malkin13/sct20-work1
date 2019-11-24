package lession03;

import org.junit.Assert;
import org.junit.Test;

public class MathBoxTest {
    private Number[] numbers = {1, 2, 3, 4, 4, 4, 5, 6};
    private MathBox mathBox = new MathBox(numbers);
    private ObjectBox objectBox = new ObjectBox(numbers);

    //MathBox
    @Test
    public void TestSummator() {
        Assert.assertEquals("The number equals", 21, mathBox.summator());
    }

    @Test
    public void TestSplitter() {
        mathBox.splitter(3);
        String res = String.valueOf(mathBox);
        Assert.assertEquals("The number equals", "MathBox{numbers=[0, 1, 2]}", res);
    }
    @Test
    public void TestRemove() {
        mathBox.remove(2);
        String res = String.valueOf(mathBox);
        //System.out.println(mathBox);
        Assert.assertEquals("The number equals", "MathBox{numbers=[1, 3, 4, 5, 6]}", res);
    }


    //ObjectBox
    @Test
    public void TestAdd() {
        objectBox.addObject(9);
        String res = String.valueOf(objectBox);
        Assert.assertEquals("The number equals", "ObjectBox{objects=[1, 2, 3, 4, 5, 6, 9]}", res);
    }

    @Test
    public void TestRemoveO() {
        objectBox.deleteObject(6);
        String res = String.valueOf(objectBox);
       // System.out.println(res);
        Assert.assertEquals("The number equals", "ObjectBox{objects=[1, 2, 3, 4, 5]}", res);
    }

}
