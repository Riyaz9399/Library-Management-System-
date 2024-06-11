package pkg_Book;

import java.io.Serializable;

public class Book implements Serializable {
    private int Isbn ;
    private String title;
    private String author ;
    private String publisher;
    private int edition;
    private String subject;
    private int Quantity;

    public void  setIsbn(int Isbn){
        this.Isbn  = Isbn;
    }

    public int getIsbn(){
        return Isbn;
    }

    public void setTitle(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getAuthor (){
        return author;
    }

    public void setPublisher(String publisher){
        this.publisher = publisher;
    }

    public String getPublisher(){
        return publisher;
    }

    public void  setEdition(int edition){
        this.edition = edition;
    }
    public int getEdition(){
        return edition;
    }

    public void setSubject(String subject){
        this.subject = subject;
    }
    public String getSubject(){
        return subject;
    }
    public void setQuentity(int Quantity){
        this.Quantity = Quantity;
    }
    public int getQuentity(){
        return Quantity;
    }

    //  Constructor for BOOK 
    public Book(int Isbn, String title , String author, String publisher,int edition ,String subject , int Quantity){
        super();
        this.Isbn = Isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.edition = edition;
        this.subject = subject;
        this.Quantity = Quantity;
    }

    public Book(){

    }

    public String toString(){
        return " [ ISBN = " + Isbn + ", TITLE = " + title + ", AUTHOR = " + author + ", PUBLISHER = " + publisher + ", EDITION = " + edition + ", SUBJECT = " + subject + ", QUANTITY = " + Quantity;
    }


}
