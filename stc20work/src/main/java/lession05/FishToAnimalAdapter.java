package lession05;

public class FishToAnimalAdapter implements Animal {

    private final Fish fish;

    public FishToAnimalAdapter() {
        fish = new Fish();
    }


    @Override
    public void voice() {
        System.out.println("Blub");
    }
}
