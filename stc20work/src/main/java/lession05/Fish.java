package lession05;

import lession02.task03.Person;
import lombok.Data;

@Data
public class Fish {
    private Integer id;
    private String fishName;
    private Person owner;
    private double weight;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFishName() {
        return fishName;
    }

    public void setFishName(String fishName) {
        this.fishName = fishName;
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

    public Fish(Integer id, String fishName, Person owner, double weight) {
        this.id = id;
        this.fishName = fishName;
        this.owner = owner;
        this.weight = weight;
    }


    @Override
    public String toString() {
        return "Animal {" +
                "id= " + id +
                ", fishName='" + fishName +
                ", weight=" + weight + '\''+
                ", owner=" + owner +
                '}';
    }

    @Override
    public int hashCode() {
        return fishName.hashCode();
    }

}
