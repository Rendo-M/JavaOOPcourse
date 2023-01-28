package homework1;

import java.util.ArrayList;

public class DogSitter extends Persone {

    String name;
    String phone;
    private ArrayList<Dog> dogs;



    public void stopWalk(Dog dog){
        if (dogs.contains(dog))
            dogs.remove(dog);
    }

    public boolean isWalk(Dog dog){
        return dogs.contains(dog);
    }

    DogSitter(String name, String phone){
        super(name, phone);
    }

   
    
}
