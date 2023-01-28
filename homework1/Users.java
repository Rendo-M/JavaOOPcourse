package homework1;

import java.util.ArrayList;

public class Users {
    ArrayList<Persone> userList;
    Users(){
        this.userList = new ArrayList<>(); 
    }

    public void addUser(Persone user) {
        userList.add(user);
    }
    public DogSitter findDogSitter(){
        Persone user = null; 
        for (Persone persone : userList) {
            if (persone instanceof DogSitter) {
                user = persone;
                break;
            } 
       } 
       return (DogSitter) user; 
    }

    @Override
    public String toString(){
        String s = "";
        for (Persone persone : userList) {
            s = s + persone.toString() + "\n****************\n";
        }
        return s;
    }

}
