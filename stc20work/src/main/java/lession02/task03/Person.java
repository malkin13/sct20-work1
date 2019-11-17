package lession02.task03;

/**
 * Object person
 */
public class Person implements Comparable<Person> {

    private int age;
    private sex sex;
    private String name;

    public Person() {
        this.age = age;
        this.sex = sex;
        this.name = name;
    }

    int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person.sex getSex() {
        return sex;
    }

    public void setSex(Person.sex sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    @Override
//    public String toString() {
//        return "Name: '" + this.name + "', Age: '" + this.age + "', Sex: '" + this.sex + "'" + "\n";
//    }

    @Override
    public String toString() {
        return "Person {" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }

    public enum sex {MAN, WOMAN}

}
