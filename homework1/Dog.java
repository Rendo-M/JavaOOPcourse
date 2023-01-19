package homework1;

public class Dog {
    private String name;
    private String breed;
    DogOwner owner;

    Dog(String name, String breed, DogOwner owner){
        this.name = name; 
        this.breed = breed;
        this.owner = owner; 
    }
    Dog(String name, String breed ){
       this(name, breed, null);       
    }
    
    Dog(String name){
        this(name, "unknown");
     }

    public String getName(){
        return this.name;
    }
    public String getBreed(){
        return this.breed;
    }
    @Override
    public String toString(){
        return this.getBreed() + " " + getName();
    }
    
}
