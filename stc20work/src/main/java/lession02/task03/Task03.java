package lession02.task03;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Дан массив объектов Person. Класс Person характеризуется полями age (возраст, целое число 0-100),
 * sex (пол – объект класса Sex со строковыми константами внутри MAN, WOMAN), name (имя - строка).
 * Создать два класса, методы которых будут реализовывать сортировку объектов.
 * Предусмотреть единый интерфейс для классов сортировки
 */
public class Task03 {

    public static void main(String[] args) throws Exception {

        System.out.println("Task 03");

        GenerateArray generateArray = new GenerateArray();
        Person[] people = generateArray.generatePersons(100);




        System.out.println("-- started array");
        for (Person person : people) {
            System.out.print(person.toString());
        }

//        for (int i = 0; i < people.length ; i++) {
//            System.out.println(people[i].toString());
//            if (people[i].getName().equals(people[i].getName()) ) {
//                System.out.println("same name");
//            }
//        }

        System.out.println("|_First class");
        FirstSortClass firstSortClass = new FirstSortClass();
        firstSortClass.mainSortWithTimer(people, 100);

        System.out.println("|_Second class");
        SecondSortClass secondSortClass = new SecondSortClass();
        secondSortClass.mainSortWithTimer(people, 100);

    }

    /**
     * first class implements SortIface
     */
    public static class FirstSortClass implements SortIface {

        @Override
        public void mainSortWithTimer(Person[] mainPeople, int arraySize) {
            TimeMeter firstTimeMeter = new TimeMeter();
            alphabetSortMethod(mainPeople, arraySize);
            ageSortMethod(mainPeople, arraySize);

            System.out.println("-- sorted array");
            for (Person person : manSortMethod(mainPeople, arraySize)) {
                System.out.print(person.toString());
            }

            System.out.println("first method - " + firstTimeMeter);
        }

        @Override
        public Person[] manSortMethod(Person[] manFirstPeople, int size) {
            Arrays.sort(manFirstPeople, Comparator.comparing(Person::getSex));
            return manFirstPeople;
        }

        @Override
        public Person[] ageSortMethod(Person[] oldFirstPeople, int size) {
            Person[] result = new Person[size];
            boolean sorted = false;
            Person temp;
            while (!sorted) {
                sorted = true;
                for (int i = 0; i < oldFirstPeople.length - 1; i++) {
                    if (oldFirstPeople[i].getAge() < oldFirstPeople[i + 1].getAge()) {
                        temp = oldFirstPeople[i];
                        oldFirstPeople[i] = oldFirstPeople[i + 1];
                        oldFirstPeople[i + 1] = temp;
                        sorted = false;
                    }
                }

                result = oldFirstPeople;
            }
            return result;
        }

        @Override
        public Person[] alphabetSortMethod(Person[] abcFirstPeople, int arraySize) {
            Arrays.sort(abcFirstPeople, Comparator.comparing(Person::getName));
            return abcFirstPeople;
        }
    }

    /**
     * second class implements SortIface
     */
    public static class SecondSortClass implements SortIface {

        @Override
        public void mainSortWithTimer(Person[] mainPeople, int arraySize) {
            TimeMeter secondTimeMeter = new TimeMeter();
            alphabetSortMethod(mainPeople, arraySize);
            ageSortMethod(mainPeople, arraySize);

            System.out.println("-- sorted array");
            for (Person person : manSortMethod(mainPeople, arraySize)) {
                System.out.print(person.toString());
            }
            System.out.println("second method - " + secondTimeMeter);
        }

        @Override
        public Person[] manSortMethod(Person[] manFirstPeople, int size) {
            Arrays.sort(manFirstPeople, Comparator.comparing(Person::getSex));
            return manFirstPeople;
        }

        @Override
        public Person[] ageSortMethod(Person[] oldFirstPeople, int size) {
            Arrays.sort(oldFirstPeople, (p1, p2) -> p2.getAge() - p1.getAge());
            return oldFirstPeople;
        }

        @Override
        public Person[] alphabetSortMethod(Person[] abcFirstPeople, int arraySize) {
            Arrays.sort(abcFirstPeople, Comparator.comparing(Person::getName));
            return abcFirstPeople;
        }
    }


}
