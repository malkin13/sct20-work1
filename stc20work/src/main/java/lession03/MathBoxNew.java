package lession03;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

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
public class MathBoxNew extends ObjectBox {

    private HashSet<Object> objects;

    public MathBoxNew(Number[] arrayOfNumber) {
        super(arrayOfNumber);
        //super.objects = new HashSet<>(Arrays.asList(arrayOfNumber));
    }

    @Override
    public void addObject(Object toAdd) {
        super.addObject(toAdd);
    }

    @Override
    public void deleteObject(Object toRemove) {
        super.deleteObject(toRemove);
    }


    public int summator() {
        return objects.stream()
                .mapToInt(x -> (Integer) x)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public void splitter(final int devider) {
        objects = objects.stream()
                .mapToInt(x -> (Integer) x)
                .map(x -> x / devider)
                .mapToObj(x -> (Number) x)
                .collect(Collectors.toCollection(HashSet::new));
    }

    public void removeInt(Integer num) {
        objects.remove(num);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "numbers=" + objects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBoxNew mathBox = (MathBoxNew) o;
        return Objects.equals(objects, mathBox.objects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objects);
    }
}
