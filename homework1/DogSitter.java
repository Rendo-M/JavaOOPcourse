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
        if (this.dogs != null)
        return dogs.contains(dog);
        return false;
    }

    DogSitter(String name, String phone){
        super(name, phone);
    }

    public void addDog(Dog dog) {
    if (! this.isWalk(dog))
        super.addDog(dog);
    }    
    
    public String toString(){
        return "Dogsitter \n"+super.toString();
    }

   
    
}
