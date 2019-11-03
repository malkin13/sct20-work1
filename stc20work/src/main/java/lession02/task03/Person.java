package lession02.task03;

import java.util.Comparator;

/**
 * Object person
 */
public class Person implements Comparable<Person> {

    private int age;
    private sex sex;
    private String name;

    public Person() {}

    public int getAge() {
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

    //Comparator for age sort
    public static Comparator<Person> AgeComparator = new Comparator<Person>() {

        @Override
        public int compare(Person p1, Person p2) {
            return p2.getAge() - p1.getAge();
        }
    };

    //Comparator for sex sort
    public static Comparator<Person> SexComparator = new Comparator<Person>() {

        @Override
        public int compare(Person p1, Person p2) {
            return p1.getSex().compareTo(p2.getSex());
        }
    };

    //Comparator for name sort
    public static Comparator<Person> NameComparator = new Comparator<Person>() {

        @Override
        public int compare(Person p1, Person p2) {
            return p1.getName().compareTo(p2.getName());
        }
    };
    //
    public enum sex{ MAN,WOMAN}

}
