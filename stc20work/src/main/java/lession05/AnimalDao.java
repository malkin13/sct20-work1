package lession05;

import lession02.task03.Person;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AnimalDao {

    public static final Set<Animal> animalSet =new HashSet<Animal>();


    public void initAnimals() throws Exception {
        Person elena = new Person();
        elena.setName("Elena");
        elena.setAge(32);
        elena.setSex(Person.sex.WOMAN);

        Person kolya = new Person();
        kolya.setName("Kolya");
        kolya.setAge(52);
        kolya.setSex(Person.sex.MAN);

        Animal dog = new Animal(1,"senya",elena,59.2);
        Animal cat = new Animal(2,"tosya",elena,6.1);
        Animal cat1 = new Animal(3,"busya",kolya,4.0);

        animalSet.add(dog);
        animalSet.add(cat);
        animalSet.add(cat1);

        System.out.println("-- initAnimals-- ");
       // System.out.println();
        getAllAnimals();
        System.out.println("-- add Animals-- ");
        Animal dog1 = new Animal(4,"lana",kolya,11.0);
        // throw addAnimal(dog);
        addAnimal(dog1);
        System.out.println("-- find Animals-- ");
        findAnimalByMoniker(dog1.getMoniker());
        System.out.println("-- update Animals-- ");
        Animal dog1_new = new Animal(4,"nusha",kolya,10.0);
        updateAnimal(dog1.getId(),dog1_new);

    }

    public Animal addAnimal(Animal animal) throws Exception {
        if(animalSet.add(animal)){
            System.out.println("added"+ animal);
        }else{
            throw new Exception("Animal not added, because it was already present");
        }
        return animal;
    }

    public void updateAnimal(Integer id,Animal newAnimal) throws Exception {
        for (Animal animal:animalSet ) {
            if (animal.getId().equals(id)) {
                deleteAnimal(animal);
                addAnimal(newAnimal);
            }
        }
    }

    public void deleteAnimal(Animal animal) {
        boolean result = animalSet.remove(animal);
        if(result){
            System.out.println(animal+ " was removed");
        } else {
            System.out.println(animal+"not found");
        }
        animalSet.remove(animal);
    }

    public void findAnimalByMoniker(String animalMoniker) {
        Iterator<Animal> iterator = animalSet.iterator();
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

    public void getAllAnimals() {
        String result = "";
        Iterator<Animal> iterator = animalSet.iterator();
        while(iterator.hasNext()){
           // result =  iterator.next().toString();
            System.out.println( iterator.next() );
        }
        //todo в отсортированном порядке. Поля для сортировки –  хозяин, кличка животного, вес.
        //return result;
    }
}
