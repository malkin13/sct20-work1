package lession08;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class ProxyAndReflectionTest {

    private ProxyAndReflection proxyAndReflection = new ProxyAndReflection();
    private String filePath = "/Users/internet/IdeaProjects/STC-20/stc20work/src/main/resources/lession08.bin";

    @Test
    public void TestProxy() throws IOException, ClassNotFoundException {
        Owner elena = new Owner(33,"Elena");

        proxyAndReflection.serialize(elena,filePath);
        String elenaFromFile = proxyAndReflection.deSerialize(filePath).toString();
        Assert.assertEquals(elena.toString(),elenaFromFile);
    }
    @Test
    public void TestProxy1() throws IOException, ClassNotFoundException {
        proxyAndReflection.serialize(new Owner(10,"Andrey"),filePath);
        String andreyFromFile = proxyAndReflection.deSerialize(filePath).toString();
        String andrey = "Person {name='Andrey', age=10}";
        Assert.assertEquals(andrey,andreyFromFile);

    }
}
