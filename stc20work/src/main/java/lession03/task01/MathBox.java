package lession03.task01;

import java.util.*;

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

        Integer[] array =  (Integer[]) getRandom(8,5);
        arrayCheck(array);
        //System.out.println();
    }

    private <T> T summator(Object input){

        return null;
    }

    private <T> T  splitter(Object input) {

        return null;
    }

    private void remover(Integer element){

    }

    public static void arrayCheck(Integer[] array){
        HashSet<Integer> used = new HashSet<>();

        for(int i = 0; i < array.length; i++){
            if(used.contains(array[i])){
                continue;
            } else {
                used.add(array[i]);
            }
            ArrayList<Integer> positions = new ArrayList<>();
            positions.add(i);
            for(int j = i + 1; j < array.length; j++){

                if(array[i] == array[j]){
                    positions.add(j);
                }
            }
            System.out.print(array[i] + " встречается в позициях " );
            for(Integer p : positions){
                System.out.print(p + ", ");
            }
            System.out.println();
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }


    private static Number[] getRandom(int length, int range) {
         Number[] rNumbers=new Number[length];
        for (int i = 0; i < length ; i++) {

            Object rnd = new Random().nextInt(range);
            Number rnd1 = (Number) new Random().nextInt(range);
            System.out.println(rnd1);

            for (int j = 0; j <  length; j++) {
                rNumbers[j] = rnd1;
            }
        }

        return rNumbers;
    }

    private static Number[] checkDuplicate(Number[] array) {
        LinkedHashSet<Number> linkedHashSet = new LinkedHashSet<>(Arrays.asList(array));
        return linkedHashSet.toArray(new Number[]{});
    }
}
