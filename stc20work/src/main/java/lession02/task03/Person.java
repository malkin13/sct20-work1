package lession02.task03;

/**
 * Object person
 */
public class Person implements Comparable<Person> {

    private int age;
    private sex sex;
    private String name;

    Person() {
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
    }

    Person.sex getSex() {
        return sex;
    }

    void setSex(Person.sex sex) {
        this.sex = sex;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: '" + this.name + "', Age: '" + this.age + "', Sex: '" + this.sex + "'" + "\n";
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }

    public enum sex {MAN, WOMAN}

}
