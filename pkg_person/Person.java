package pkg_person;




import java.util.regex.Pattern;

abstract public class Person  {
    protected String name;
    protected String email; 
    protected String phoneNumberStr ;
    protected String address;
    protected String DOB;
    
    public void setName(String name){
       this.name = name;
       
    }
    public String getName(){
        return name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setPhoneNumber(String phoneNumberStr){
       this.phoneNumberStr = phoneNumberStr;
    }
    
       

    public long getPhonenumber(){
        long phoneNumber = Long.parseLong(phoneNumberStr);
        return phoneNumber;
    }

    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }

    public void setDOB(String DOB){
        boolean isvalidDOB = Pattern.matches("\\d(2)+ \\d(2)+\\d(4)", DOB);
        if(isvalidDOB){
            this.DOB = DOB;
        }else{
            this.DOB = "01-06-2005";
        }
        
    }
    public String getDOB(){
        return DOB;
    }

    public Person(String name , String email , String phoneNumberStr , String address , String DOB){
        this.name = name ;
        this.email = email;
        this.phoneNumberStr = phoneNumberStr;
        this.address = address;
        this.DOB = DOB;
    }

    public Person(){

    }
}