package lession02.task03;

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
        Person[] people = generateArray.generatePersons(6);

        FirstSortClass firstSortClass = new FirstSortClass();
        firstSortClass.firstMethodSort(people,6);



//        TimeMeter timeMeter1 = new TimeMeter();
//        Arrays.sort(people, Person.SexComparator);
//        System.out.println("Comparator по полу:\n"+Arrays.toString(people));
//        System.out.println(timeMeter1);
//
//        TimeMeter timeMeter2 = new TimeMeter();
//        Arrays.sort(people, Person.AgeComparator);
//        System.out.println("Comparator по возрасту:\n"+Arrays.toString(people));
//        System.out.println(timeMeter2);
//
//        TimeMeter timeMeter3 = new TimeMeter();
//        Arrays.sort(people, Person.NameComparator);
//        System.out.println("Comparator по имени:\n"+Arrays.toString(people));
//        System.out.println(timeMeter3);

    }

    public static class FirstSortClass implements SortIface {

        /**
         * buuble sort method
         * @param array
         */
        @Override
        public void firstMethodSort(Person[] array,int size) {
            Person[] result = new Person[size];

            boolean sorted = false;
            Person temp;
            while (!sorted) {
                sorted = true;
                for (int i =0; i < array.length -1; i++) {
                    if (array[i].getAge() > array[i+1].getAge())   {
                        temp = array[i];
                        array[i] = array[i+1];
                        array[i+1] = temp;
                        sorted = false;
                      //  System.out.println(temp);
                    }
                }
            }

//
//            boolean sorted = false;
//            int temp;
//            while(!sorted) {
//                sorted = true;
//                for (int i = 0; i < array.length - 1; i++) {
//                    if (array[i] > array[i+1]) {
//                        temp = array[i];
//                        array[i] = array[i+1];
//                        array[i+1] = temp;
//                        sorted = false;
//                    }
//                }
//            }
        }

        /**
         * Selection sort method
         * @param array
         */
        @Override
        public void secondMethodSort(Person[] array,int size) {

            for (int i = 0; i < array.length; i++) {
                int min = array[i].getAge();
                int minId = i;
                for (int j = 0; j < array.length; j++) {
                    if (array[j].getAge() < min) {
                        min = array[j].getAge();
                        minId = j;
                    }
                }
                int temp = array[i].getAge();
                array[i].setAge(min);
                array[minId].setAge(temp);
            }

//            for (int i = 0; i < array.length; i++) {
//                int min = array[i];
//                int minId = i;
//                for (int j = i+1; j < array.length; j++) {
//                    if (array[j] < min) {
//                        min = array[j];
//                        minId = j;
//                    }
//                }
//                // замена
//                int temp = array[i];
//                array[i] = min;
//                array[minId] = temp;
//            }
        }
    }

    public static class SecondSortClass implements SortIface {

        /**
         * Selection too sort method
         * @param array
         */
        @Override
        public void firstMethodSort(Person[] array,int size) {


//            for (int i = 0; i < array.length; i++) {
//                int min = array[i];
//                int minId = i;
//                for (int j = i+1; j < array.length; j++) {
//                    if (array[j] < min) {
//                        min = array[j];
//                        minId = j;
//                    }
//                }
//                // замена
//                int temp = array[i];
//                array[i] = min;
//                array[minId] = temp;
//            }
        }

        /**
         * Insert sort method
         * @param array
         */
        @Override
        public void secondMethodSort(Person[] array,int size) {



//            for (int i = 1; i < array.length; i++) {
//                int current = array[i];
//                int j = i - 1;
//                while(j >= 0 && current < array[j]) {
//                    array[j+1] = array[j];
//                    j--;
//                }
//                // в этой точке мы вышли, так что j так же -1
//                // или в первом элементе, где текущий >= a[j]
//                array[j+1] = current;
//            }
        }
    }


}
