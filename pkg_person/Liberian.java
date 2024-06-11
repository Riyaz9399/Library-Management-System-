package pkg_person;

import java.io.Serializable;

public class Liberian extends Person implements Serializable {
    private int id;
    private  String dateOfJoin;

    public void setID(int id){
        this.id = id;
    }
    public int getID(){
        return id;
    }
    public void setDATEOFJOIN(String dateOfJoin){
        this.dateOfJoin = dateOfJoin;
    }
    public String getDateOFJoin(){
        return dateOfJoin;
    }

    

    public Liberian(int id , String dateOfJoin,String name , String email , String PhoneNumberStr , String address , String DOB ){
        super(name,email, PhoneNumberStr,address,DOB);
        this.id = id;
        this.dateOfJoin = dateOfJoin;
    }

    public String toString(){
        return "ID =" + id + " NAME = " + name + " EMAIL = " + email + " Addrees =" + address + " PHONE NUMBER = " + phoneNumberStr + " DAte of Birth = " + DOB + "DATE of JOINING = " + dateOfJoin;
    }
}
