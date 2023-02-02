package homework1;

public class DogOwner extends Persone{
 

    DogOwner(String name, String phone){
        super(name, phone);
    }




    public void SetDogsitter(DogSitter ds, int dogID){
        if (this.dogs.size() >= dogID) {
        ds.addDog(this.dogs.get(dogID));}
    }
    public void SetDogSitterForAll(DogSitter ds){
        for (Dog dog : dogs) {
            if (!ds.isWalk(dog))
                ds.addDog(dog);
        }
    }

    
    public String toString(){
        return "DogOwner \n"+super.toString();
    }
}
