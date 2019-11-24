package lession08;

import java.io.Serializable;

public class Owner implements Serializable {

        private int age;
        private String name;

        public Owner(int age,String name) {
            this.age = age;
            this.name = name;
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
