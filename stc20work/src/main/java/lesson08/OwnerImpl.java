package lesson08;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;

/**
 * Owner to serialize/desirialize
 */
public class OwnerImpl implements Owner {

    private static final long serialVersionUID = 7829136421241571165L;

    private int age;
    private String name;

    public OwnerImpl(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    public OwnerImpl(){
        super();
    }

    int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person {" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void save(Object out){

        //в удобном вам порядке записываете свой объект
    }

    public Object load (InputStream in){

        return null;
    }


    @Override
    public String comeHere() {
        return "Сюда иди!";
    }
}
