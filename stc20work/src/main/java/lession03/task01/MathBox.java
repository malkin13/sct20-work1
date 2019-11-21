package lession03.task01;

import java.util.*;
import java.util.stream.Collectors;
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

    private HashSet<Number> numbers;

    public MathBox(Number[] arrayOfNumber) {
        numbers = new HashSet<>(Arrays.asList(arrayOfNumber));
    }

    public int summator() {
        return numbers.stream()
                .mapToInt(x -> (Integer) x)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public void splitter(final int devider) {
        numbers = numbers.stream()
                .mapToInt(x -> (Integer) x)
                .map(x -> x / devider)
                .mapToObj(x -> (Number) x)
                .collect(Collectors.toCollection(HashSet::new));
    }

    public void remove(Integer num) {
        numbers.remove(num);
    }

    @Override
    public String toString() {
        return "MathBox{" +
                "numbers=" + numbers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MathBox mathBox = (MathBox) o;
        return Objects.equals(numbers, mathBox.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
