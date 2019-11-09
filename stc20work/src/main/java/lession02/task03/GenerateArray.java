package lession02.task03;

import java.util.HashMap;
import java.util.Random;

class GenerateArray {

    /**
     * @return generated array of person
     */
    Person[] generatePersons(int elements) {

        Person[] people = new Person[elements];

        // эта мапа для матчинга имени и пола
        HashMap<String, Person.sex> namesWithSexMap = new HashMap();

        namesWithSexMap.put("Ann", Person.sex.WOMAN);
        namesWithSexMap.put("Alex", Person.sex.MAN);
       // namesWithSexMap.put("Alex", Person.sex.WOMAN);
        namesWithSexMap.put("Vasya", Person.sex.MAN);
        namesWithSexMap.put("Petya", Person.sex.MAN);
        namesWithSexMap.put("Alice", Person.sex.WOMAN);
        namesWithSexMap.put("Katya", Person.sex.WOMAN);
        namesWithSexMap.put("Sasha", Person.sex.MAN);
        namesWithSexMap.put("Masha", Person.sex.WOMAN);
        namesWithSexMap.put("Amaliya", Person.sex.WOMAN);
        namesWithSexMap.put("Victoria", Person.sex.WOMAN);
        namesWithSexMap.put("Igor", Person.sex.MAN);
        namesWithSexMap.put("Dima", Person.sex.MAN);
        namesWithSexMap.put("Veronika", Person.sex.WOMAN);

        Random rnd = new Random();

        for (int i = 0; i < elements; i++) {
            Object randomName = namesWithSexMap.keySet()
                    .toArray()[new Random().nextInt(namesWithSexMap.keySet().toArray().length)];

            Person person = new Person();
            person.setName(randomName.toString());
            person.setAge(rnd.nextInt(95));
            person.setSex(namesWithSexMap.get(randomName));
            people[i] = person;
        }

        return people;
    }

    //todo trow new exception when array contains same name and age
}
