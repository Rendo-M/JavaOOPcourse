package homework1;

public class DogOwner extends Persone{
 

    DogOwner(String name, String phone){
        super(name, phone);
    }




    public void SetDogsitter(DogSitter ds, int dogID){
        if (this.dogs.size() >= dogID) {
        ds.addDog(this.dogs.get(dogID));}
    }

}
