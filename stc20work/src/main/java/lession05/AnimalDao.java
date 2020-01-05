package lession05;

import lession02.task03.Person;

import java.util.*;
import java.util.stream.Collectors;

/**
 * object data access
 */
public class AnimalDao {

    public static final Set<AnimalData> animalSet =new HashSet<AnimalData>();

    /**
     * main method init
     * @throws Exception
     */

    public void initAnimals() throws Exception {
        Person elena = new Person();
        elena.setName("Elena");
        elena.setAge(32);
        elena.setSex(Person.sex.WOMAN);

        Person kolya = new Person();
        kolya.setName("Kolya");
        kolya.setAge(52);
        kolya.setSex(Person.sex.MAN);

        AnimalData dog = new AnimalData(1,"senya",elena,59.2);
        AnimalData cat = new AnimalData(2,"tosya",elena,6.1);
        AnimalData cat1 = new AnimalData(3,"busya",kolya,4.0);

        animalSet.add(dog);
        animalSet.add(cat);
        animalSet.add(cat1);

        System.out.println("-- initAnimals-- ");
       // System.out.println();
        getAllAnimals();
        System.out.println("-- add Animals-- ");
        AnimalData dog1 = new AnimalData(4,"lana",kolya,11.0);
        // throw addAnimal(dog);
        addAnimal(dog1);
        System.out.println("-- find Animals-- ");
        findAnimalByMoniker(dog1.getMoniker());
        System.out.println("-- update Animals-- ");
        AnimalData dog1_new = new AnimalData(4,"nusha",kolya,10.0);
        updateAnimal(dog1.getId(),dog1_new);

    }

    /**
     * Method to add Animal
     * @param animal
     * @return
     * @throws Exception when already exist
     */
    public void addAnimal(AnimalData animal) throws Exception {
        if(animalSet.add(animal)){
            System.out.println("added"+ animal);
        }else{
            throw new Exception("Animal not added, because it already exist");
        }
    }

    /**
     * update animal find by ID remove, after than add
     * @param id find by ID
     * @param newAnimal animal to add
     * @throws Exception when already exist
     */
    public void updateAnimal(Integer id, AnimalData newAnimal) throws Exception {
        for (AnimalData animal:animalSet ) {
            if (animal.getId().equals(id)) {
                deleteAnimal(animal);
                addAnimal(newAnimal);
            }
        }
    }

    /**
     * remove animal
     * @param animal to remove
     */
    public void deleteAnimal(AnimalData animal) {
        boolean result = animalSet.remove(animal);
        if(result){
            System.out.println(animal+ " was removed");
        } else {
            System.out.println(animal+"not found");
        }
        animalSet.remove(animal);
    }

    /**
     * find Animal By Moniker
     * @param animalMoniker  to find
     */
    public void findAnimalByMoniker(String animalMoniker) {
        Iterator<AnimalData> iterator = animalSet.iterator();
        boolean found = false;
        while(iterator.hasNext()){
            found = iterator.next().getMoniker().equals(animalMoniker);
        }
        if (found) {
            System.out.println("Animal founded " + found + "_ "+  animalMoniker);
        } else {
            System.out.println("Animal not founded " + found + "_ "+  animalMoniker);
        }

    }

    /**
     * show all animals
     */
    public void getAllAnimals() {
        animalSet.stream().sorted(new Comparator<AnimalData>() {
            @Override
            public int compare(AnimalData a1, AnimalData a2) {
                return a1.getMoniker().compareTo(a2.getMoniker());
            }
        }).collect(Collectors.toList());

        for (AnimalData animal:animalSet ) {
            System.out.println(animal);
        }

        //todo в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.

    }
}
