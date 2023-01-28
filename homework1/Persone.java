package homework1;

import java.util.ArrayList;

public abstract class Persone {
    String name;
    String phone;
    protected ArrayList<Dog> dogs;

    Persone(String name, String phone){
            this.name = name;
            this.phone = phone;
            this.dogs = new ArrayList<>();
        }
    @Override
    public String toString() {
        return this.name + "\n" + this.phone + "\n" + dogs;   
    }  
      
    public void addDog(Dog dog) {
        this.dogs.add(dog);
    }



    }

