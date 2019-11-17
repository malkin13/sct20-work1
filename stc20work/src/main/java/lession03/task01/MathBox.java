package lession03.task01;

import java.util.*;
import java.util.stream.IntStream;

/**
 * Конструктор на вход получает массив Number. Элементы не могут повторяться.
 * Элементы массива внутри объекта раскладываются в подходящую коллекцию (выбрать самостоятельно).
 * Существует метод summator, возвращающий сумму всех элементов коллекции.
 * Существует метод splitter, выполняющий поочередное деление всех хранящихся в объекте элементов на делитель, являющийся аргументом метода.
 * Хранящиеся в объекте данные полностью заменяются результатами деления.
 * Необходимо правильно переопределить методы toString, hashCode, equals,
 * чтобы можно было использовать MathBox для вывода данных на экран и хранение объектов этого класса в коллекциях (например, hashMap).
 * Выполнение контракта обязательно!
 * Создать метод, который получает на вход Integer и если такое значение есть в коллекции, удаляет его.
 */
public class MathBox {

    public static void main(String[] args) {
        mb(getRandom(5,8));
    }

    public static void mb(Number[] array) {
        System.out.println("---- toSet --- ");
        Set<Number> tempSet = new HashSet<>();
        for (Number elements: array         ) {
            tempSet.add(elements);
        }
        System.out.println(tempSet);
        System.out.println("---- toSet --- ");
       // summator(tempSet);
       // splitter(tempSet,4.0);

    }

    private static void summator(Object input){
        System.out.println("---- summ --- ");
        Set<Number> sumResultSet =  new HashSet<>();
        sumResultSet = (Set<Number>) input;
        //IntStream.of(Arrays.asList(sumResultSet)).sum();

       // sumResult.stream().map(Line::getLength).mapToInt(Number::intValue).sum();
        System.out.println(sumResultSet);
    }

    private static  <T> T  splitter(Object input,double delimiter) {

        return null;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    //    private void remover(Object input,Integer toRemove) {
//        if (input.contains(toRemove)) {
//            for (MyObject obj : input) {
//                if (obj.equals(toRemove))
//                    return obj;
//            }
//        }
//    }

    private static Number[] getRandom(int length, int range) {
        System.out.println("---- rnd --- ");
        Number[] rNumbers=new Number[length];
        for (int i = 0; i < length ; i++) {

            Object rnd = new Random().nextInt(range);
            Number rnd1 = (Number) new Random().nextInt(range);
            System.out.println(rnd1);

            for (int j = 0; j <  length; j++) {
                rNumbers[j] = rnd1;
            }
        }
        System.out.println("---- rnd --- ");
        return rNumbers;

    }



//
//    public static void arrayCheck(Integer[] array){
//        HashSet<Integer> used = new HashSet<>();
//
//        for(int i = 0; i < array.length; i++){
//            if(used.contains(array[i])){
//                continue;
//            } else {
//                used.add(array[i]);
//            }
//            ArrayList<Integer> positions = new ArrayList<>();
//            positions.add(i);
//            for(int j = i + 1; j < array.length; j++){
//
//                if(array[i] == array[j]){
//                    positions.add(j);
//                }
//            }
//            System.out.print(array[i] + " встречается в позициях " );
//            for(Integer p : positions){
//                System.out.print(p + ", ");
//            }
//            System.out.println();
//        }
//    }

    private static Number[] checkDuplicate(Number[] array) {
        LinkedHashSet<Number> linkedHashSet = new LinkedHashSet<>(Arrays.asList(array));
        return linkedHashSet.toArray(new Number[]{});
    }
}
