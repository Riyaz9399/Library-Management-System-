package pkg_Exception;

public class StudentNotFoundException extends Exception{

    private static final long serialVersionUID = 1L;
    
    public StudentNotFoundException(){
        super();
    }

    public String toString(){
        return "StudentNotfoundException is Generated";
    }
}
