package lession05;

import lession02.task03.Person;

import java.util.*;

public class Main {


    private static final Map<Integer, Animal> animalMap = new HashMap<Integer, Animal>();
    public static void main(String[] args) throws Exception {
        AnimalDao animalDao = new AnimalDao();
        animalDao.initAnimals();
    }


    public static List<Animal> getAllAnimals() {
        Collection<Animal> c = animalMap.values();
        List<Animal> list = new ArrayList<Animal>();
        list.addAll(c);
        return list;
    }

    List<Animal> list;
}
