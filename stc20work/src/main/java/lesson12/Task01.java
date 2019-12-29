package lesson12;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Task01 {

    public static void main(String[] args) throws Exception{
        Class unsafeClass = Class.forName("sun.misc.Unsafe");
        Field f = unsafeClass.getDeclaredField("theUnsafe");
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);
        try
        {
            for(;;)
                unsafe.allocateMemory(1024*1024);
        } catch(Error e) {
            System.out.println("Memory over..");
            e.printStackTrace();
        }
    }




}
