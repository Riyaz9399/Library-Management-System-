package pkg_Exception;

public class BookNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;
    
    public BookNotFoundException(){
        super();
    }

    public String toString(){
        return "BooKNotFoundException is Generated ";
    }
}
