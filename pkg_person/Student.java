package pkg_person;

import java.io.Serializable;

public class Student extends Person  implements Serializable{
    private int rollNo;
    private int std;
    private String devision ;


    public void setRollNo(int rollNo){
        this.rollNo = rollNo;
    }
    public void setStd(int std){
        this.std = std;
    }
    public void setDevision(String devision){
        this.devision = devision;
    }

    public int getRollNo(){
        return rollNo;
    }
    public int getStd(){
        return std;
    }
    public String getDevision(){
        return devision;
    }

    public Student( int rollNo , int std, String devision, String name , String email , String phoneNumberStr , String address , String DOB){
        super(name , email, phoneNumberStr,address,DOB);
        this.rollNo = rollNo;
        this.std = std;
        this.devision = devision;
    }
    public Student(){

    }

    public String toString(){
        return "[ Roll Number = " + rollNo + ", NAme = "+  name + ", DEVISION = " + devision + ", STD (STANDARD Devision) = " + std + ", EMAIL = " + email + ", Phone Number = " + phoneNumberStr + ", Address = " + address + ", DOB =  " + DOB  + " ]";
    }

}
