package lession05;


import lession02.task03.Person;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Animal {

    private String uuid;

    private String name;

    private Person owner;

    private double weight;

    Animal() {
    }

    @Override
    public String toString() {
        return String.format("--Animal id: %s name: %s, %f )", uuid, name, weight);
    }
}
