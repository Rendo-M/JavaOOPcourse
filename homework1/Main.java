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
    DogSitter Samuel = new DogSitter("Samuel", "111334");

    Users users = new Users();
    users.addUser(Samuel);
    users.addUser(Billy);
    for (Persone user : users.userList) {
        if (user instanceof DogOwner){
           ((DogOwner) user).SetDogSitterForAll(users.findDogSitter());
        }
    }   
    System.out.println(users); 
    }
    
}

