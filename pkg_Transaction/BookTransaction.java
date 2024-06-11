package pkg_Transaction;

import java.io.Serializable;

public class BookTransaction implements Serializable {
    private int isbn;
    private int rollNo;
    private String issueDate;
    private String returnDate;
    

    public void setIsbn(int isbn){
        this.isbn = isbn;
    }
    public void setRollNo(int rollNo){
        this.rollNo = rollNo;
    }
    public  void setIssueDate(String issueDate){
        this.issueDate = issueDate;
    }
    public void setReturnDate(String returnDate){
        this.returnDate = returnDate;
    }

    public int getIsbn(){
        return isbn;
    }

    public int getRollNo(){
        return rollNo;
    }

    public String getIssueDate(){
        return issueDate;
    }
    public String getReturnDate(){
        return returnDate;
    }

    public BookTransaction(int isbn , int rollNo , String issueDate , String returnDate){
        
        this.isbn = isbn;
        this.rollNo = rollNo;
        this.returnDate = returnDate;
        this.issueDate = issueDate;
    }

    public BookTransaction(){

    }

    public String toString(){
        return "Book Transaction : " + "Isbn Code = " + isbn + " Roll number = " + rollNo + " Isseu Date = " + issueDate + " Return Date = " +  returnDate;
    }
}
