package lession05;


import lession02.task03.Person;
import lombok.Data;

/**
 * Data class for Animal
 */
@Data
public class Animal {

    private Integer id;
    private String moniker;
    private Person owner;
    private double weight;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoniker() {
        return moniker;
    }

    public void setMoniker(String moniker) {
        this.moniker = moniker;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Animal(Integer id, String moniker, Person owner, double weight) {
        this.id = id;
        this.moniker = moniker;
        this.owner = owner;
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "Animal {" +
                "id= " + id +
                ", moniker='" + moniker +
                ", weight=" + weight + '\''+
                ", owner=" + owner +
                '}';
    }

    @Override
    public int hashCode() {
        return moniker.hashCode();
    }
    @Override
    public boolean equals(Object obj) {
        return moniker.equals(((Animal) obj).moniker);
    }
}
