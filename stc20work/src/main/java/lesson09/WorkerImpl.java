package lesson09;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class WorkerImpl implements Worker {



    public static void main(String[] args) throws Exception {
        WorkerImpl worker = new WorkerImpl();

       // worker.javac(new File("/Users/internet/IdeaProjects/STC-20/stc20work/src/main/java/lesson09/SomeClass"));

        worker.doWork();

       // worker.RunSomeClass();

     //   WorkerImpl worker = new WorkerImpl("start");
    }

    @Override
    public void doWork() {
        MyClassLoader loader = new MyClassLoader();
        Class cl = null;
        try {
            cl = loader.findClass("SomeClass.class");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(cl);
        Method method = null;
        try {
            Method method2 = cl.getMethod("load2", new Class[]{String.class});
            method2.invoke(cl, "QWERRTY");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println(method);

    }


    private void javac(File file) throws Exception {
        // os type by separator
        Properties p = System.getProperties();
        String sep = p.getProperty("file.separator");
        String jrePath = p.getProperty("java.home");

        int lastPath = jrePath.lastIndexOf(sep);
        String javacPath = jrePath.substring(0, lastPath) + sep + "bin" + sep + "javac";
        File jc = new File(javacPath);
        if(!jc.isFile())
            throw new FileNotFoundException("can't find javac by path "+ jc.getAbsolutePath());

        System.out.println("comple " + jc.getAbsolutePath() + " " + file.getAbsolutePath());
        Process p1 = Runtime.getRuntime().exec(javacPath+" "+file.getAbsolutePath());

        if(p1.waitFor()!=0)
            try {
                throw new Exception("Ошибка компиляции");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }

        //Здесь мы уже имеем созданный файл с байт-кодом
        System.out.println("compile done");
        //Формируем абсолютный путь к файлу с байт-кодом
        int pointIndex = file.getAbsolutePath().lastIndexOf(".");
        String absulutePatch = file.getAbsolutePath().substring(0, pointIndex);



    }

    private void RunSomeClass(){
        SomeClass someClass = new SomeClass();
        someClass.load1();
    }
}
