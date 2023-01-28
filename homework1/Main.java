package homework1;

import java.util.ArrayList;

/*
 * Application helps dogowners found dog sitters which can walk the dog if the owner of the dog is at work
*/
public class Main {
    public static void main(String[] args) {
        
    
    DogOwner Billy = new DogOwner("Billy", "808080");
    Dog pet1 = new Dog("Charlie", "Haskey", Billy);
    Billy.addDog(pet1);
    Dog pet2 = new Dog("Wolfy", "Alabay", Billy);
    Billy.addDog(pet2);
    System.out.println(Billy);
    System.out.println("*****************");
    DogSitter Samuel = new DogSitter("Samuel", "111334");
    Billy.SetDogsitter(Samuel, 0);
    System.out.println(Samuel);
    System.out.println("*****************");
    Billy.SetDogsitter(Samuel, 1);
    Billy.SetDogsitter(Samuel, 1);
    System.out.println(Samuel);
    ArrayList <Persone> users = new ArrayList<>();
    
    }
}
