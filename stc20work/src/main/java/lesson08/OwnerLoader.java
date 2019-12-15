package lesson08;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class OwnerLoader extends ClassLoader {

    public OwnerLoader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (name.equals("OnwerImpl")) {
            String dest = "/Users/internet/IdeaProjects/STC-20/stc20work/src/main/resources/lession08.bin_";
            try {
                URL url = new URL(dest);
                URLConnection urlConnection = url.openConnection();
                InputStream inputStream = urlConnection.getInputStream();

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                int data = inputStream.read();
                while (data !=-1) {
                    baos.write(data);
                    data = inputStream.read();
                }

                inputStream.close();

                byte[] classData = baos.toByteArray();

                return defineClass(name, classData, 0, classData.length);

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return super.loadClass(name);
    }


}
