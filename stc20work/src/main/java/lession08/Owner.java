package lession08;


public class Owner {

    private static final long serialVersionUID = 7829136421241571165L;

    private int age;
    private String name;

    public Owner(int age, String name) {
        super();
        this.age = age;
        this.name = name;
    }

    public Owner(){
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


}
