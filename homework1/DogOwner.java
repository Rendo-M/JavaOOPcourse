package homework1;

import java.util.ArrayList;

public class DogOwner {
    String name;
    String phone;
    ArrayList<Dog> dogs;

    DogOwner(String name, String phone){
        this.name = name;
        this.phone = phone;
        dogs = new ArrayList<>();
    }

    public void addDog(Dog dog) {
        this.dogs.add(dog);
    }
    @Override
    public String toString() {
        return this.name + "\n" + this.phone + "\n" + dogs;
    }

    public void SetDogsitter(DogSitter ds, int dogID){
        if (this.dogs.size() >= dogID) {
        ds.askWalk(this.dogs.get(dogID));}
    }

}
