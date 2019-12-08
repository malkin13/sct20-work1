package lesson08;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Base64;
import java.util.HashMap;

/**
 * Необходимо разработать класс, реализующий следующие методы:
 * <p>
 * void serialize (Object object, String file);
 * <p>
 * Object deSerialize(String file);
 * <p>
 * Методы выполняют сериализацию объекта Object в файл file и десериализацию объекта из этого файла.
 * Обязательна сериализация и десериализация "плоских" объектов (все поля объекта - примитивы, или String).
 */
public class ProxyAndReflection {

    public static void main(String[] args) throws IllegalAccessException, IOException, ClassNotFoundException, InstantiationException {
        String filePath = "/Users/internet/IdeaProjects/STC-20/stc20work/src/main/resources/lession08.bin_";

        Object obj = printFields(new Owner(10, "Andrey"));
        System.out.println("object = " + obj);

        serialize(obj, filePath);
        deSerialize(filePath);
    }

    /**
     *  Serialize method
     * @param object what serialize
     * @param file path
     * @throws IOException
     */
    static void serialize(Object object, String file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);

        String encoded = encoding(object);
        System.out.println("encoded - " + encoded);
        fileWriter.write(encoded);
        fileWriter.close();
    }

    static String encoding(Object whatEncode) {
        return Base64.getEncoder().encodeToString(String.valueOf(whatEncode).getBytes());
    }

    static String decoding(String whatDecode) {
        return new String(Base64.getDecoder().decode(whatDecode.getBytes()));
    }

    /**
     * Deserialize method
     * @param file path
     * @return object
     * @throws IOException
     */
    static Object deSerialize(String file) throws IOException {
        FileReader fileReader = new FileReader(file);
        HashMap result = new HashMap();
        String temp = "";
        String firstPart = "";
        String secondPart = "";
        int i;
        int count = 0;
        while ((i = fileReader.read()) != -1) {
            temp += String.valueOf((char) i);
        }
        fileReader.close();

        String get = decoding(temp);
        String firstPrepare = get.replace("{", "");
        String secondPrepare = firstPrepare.replace("}", "");
        String[] allArray = secondPrepare.split(", ");

        for (int j = 0; j < allArray.length; j++) {
            firstPart = allArray[j].substring(0, allArray[j].indexOf("="));
            secondPart = allArray[j].substring(allArray[j].indexOf("=") + 1, allArray[j].length());
            result.put(firstPart, secondPart);

            System.out.println("resultFeilds - " + firstPart);
        }

        System.out.println("result - " + result);

        return result;
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
            System.out.println("declaredField - " + declaredField.get(obj));
            key = String.valueOf(declaredField.get(obj));
            result.put(key, value);
        }
        return result;
    }

}
