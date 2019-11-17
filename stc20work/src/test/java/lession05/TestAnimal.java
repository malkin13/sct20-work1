package lession05;

import org.junit.Before;
import org.junit.Test;

public class TestAnimal {


    @Test
    public void getAllSortedAnimals() {
        AnimalDao animalDao = new AnimalDao();
        System.out.println(animalDao.getAllAnimals());
    }
}
