package lession02.task03;

/**
 * Sorting interface
 */
public interface SortIface {

    void mainSortWithTimer(Person[] array, int arraySize);

    Person[] manSortMethod(Person[] manFirstPeople, int size);

    Person[] ageSortMethod(Person[] oldFirstPeople, int size);

    Person[] alphabetSortMethod(Person[] abcFirstPeople, int arraySize);

}
