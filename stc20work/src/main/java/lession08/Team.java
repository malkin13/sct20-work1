package lession08;


import lession02.task03.Person;
import lession05.Animal;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Team implements Serializable {

    @Getter
    @Setter
    private Animal animal;

    private Owner owner;


    public Team(Animal pets, Owner man) {
        this.animal = pets;
        this.owner = man;
    }


    @Override
    public String toString() {
        return "Team{" +
                "animal=" + animal +
                ", person=" + owner +
                '}';
    }
}
