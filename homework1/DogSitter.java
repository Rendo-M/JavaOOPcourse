package homework1;

import java.util.ArrayList;

public class DogSitter {

    String name;
    String phone;
    private ArrayList<Dog> toWalk;

    public void askWalk(Dog dog) {
        this.toWalk.add(dog);
    }

    public void stopWalk(Dog dog){
        if (toWalk.contains(dog))
            toWalk.remove(dog);
    }

    public boolean isWalk(Dog dog){
        return toWalk.contains(dog);
    }

    DogSitter(String name, String phone){
        this.name = name;
        this.phone = phone;
        toWalk = new ArrayList<>();
    }
    
}
