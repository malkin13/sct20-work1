package lession08;

import java.io.*;

public class ProxyAndReflection {

    void serialize(Object object, String file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(object);
        objectOutputStream.close();
    }


    Object deSerialize(String file) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object teamFromFile = (Object) objectInputStream.readObject();

      //  System.out.println(teamFromFile);
        objectInputStream.close();
        return teamFromFile;
    }
}
