package lession08;

import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Base64;
import java.util.HashMap;

public class ProxyAndReflection {


    public static void main(String[] args) throws IllegalAccessException, IOException, ClassNotFoundException, InstantiationException {
        String filePath = "/Users/internet/IdeaProjects/STC-20/stc20work/src/main/resources/lession08.bin_";

        Object obj = printFields(new Owner(10, "Andrey"));

        serialize(obj,filePath);
        deSerialize(filePath);
    }

    static void serialize(Object object, String file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);

        String encoded = encoding(object);
        fileWriter.write(encoded);
        fileWriter.close();
    }

    static String encoding(Object whatEncode) {
        return Base64.getEncoder().encodeToString(String.valueOf(whatEncode).getBytes());
    }

    static String decoding(String whatDecode) {
        return new String(Base64.getDecoder().decode(whatDecode.getBytes()));
    }

    static Object deSerialize(String file) throws IOException {
        FileReader fileReader = new FileReader(file);
        String temp = "";
        int i;
        while ((i = fileReader.read()) != -1)
            temp += String.valueOf((char) i);
        fileReader.close();
        System.out.println(temp);

        return decoding(temp);
    }

    private static HashMap printFields(Object obj) throws IllegalAccessException {
        Field[] fields = obj.getClass().getDeclaredFields();
        HashMap result = new HashMap();
        String value = "";
        String key = "";
        for (Field declaredField : fields) {
            value =
                    Modifier.toString(declaredField.getModifiers()) + " " +
                            declaredField.getType().getSimpleName() + " " +
                            declaredField.getName();
            declaredField.setAccessible(true); // доступ к приватному полю
            // System.out.println(declaredField.get(obj));
            key = String.valueOf(declaredField.get(obj));
            result.put(key, value);
        }
        return result;
    }

    private static void getObjForName(String className) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Class c = Class.forName(className);
        Object obj = c.newInstance();
        Owner owner = (Owner) obj;
    }

}
