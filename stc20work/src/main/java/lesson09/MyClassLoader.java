package lesson09;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

    /**
     * find class
     * @param name
     * @return calss to load
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File(name);
        if(!f.isFile())
            throw new ClassNotFoundException("not found class " + name);
        InputStream ins = null;
        try{
            ins = new BufferedInputStream(new FileInputStream(f));
            byte[]b = new byte[(int)f.length()];
            ins.read(b);
            //load class by defineClass
            return defineClass("SomeClass", b, 0, b.length);
        }catch (Exception e){
            e.printStackTrace();
            throw new ClassNotFoundException("problem with byte-code");
        }
        finally {
            try {
                ins.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
