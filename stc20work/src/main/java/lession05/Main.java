package lession05;

import java.util.*;

/**
 * Class for running, maybe i start use TestClasses...?
 *
 */
public class Main {

    private static final Map<Integer, Animal> animalMap = new HashMap<Integer, Animal>();

    public static void main(String[] args) throws Exception {
        AnimalDao animalDao = new AnimalDao();
        animalDao.initAnimals();
    }

}
