package lession05;

import lession02.task03.Person;

import java.util.*;

import static lession05.AnimalDao.animalSet;

/**
 * Class for running, maybe i start use TestClasses...?
 *
 */
public class Main {

    private static final Map<Integer, AnimalData> animalMap = new HashMap<Integer, AnimalData>();

    public static void main(String[] args) throws Exception {
        AnimalDao animalDao = new AnimalDao();
        animalDao.initAnimals();

        Animal Dog = new Dog();
        Dog.voice();

        Animal fish = new FishToAnimalAdapter();
        fish.voice();
    }

}
