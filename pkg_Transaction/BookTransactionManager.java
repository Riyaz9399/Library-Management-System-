package pkg_Transaction;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import pkg_Book.Book;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

public class BookTransactionManager implements Serializable {
    private static final BookTransaction[] TranscationList = null;
    ObjectOutputStream oos_Transaction = null;
    ObjectInputStream ois_Transaction = null;
    
    File TransactionFile = null;

    ArrayList<BookTransaction> BookTransactionsList = null;

    @SuppressWarnings("unchecked")
    public BookTransactionManager(){
        TransactionFile = new File("Transaction.dat");
        BookTransactionsList = new ArrayList<BookTransaction>();

        if(TransactionFile.exists()){
            try{
                ois_Transaction = new ObjectInputStream(new FileInputStream(TransactionFile));
                BookTransactionsList = (ArrayList<BookTransaction>) ois_Transaction.readObject();
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }


    public boolean issueBook(int rollNo , int isbn){
        int total_books_isshued = 0;
        for(BookTransaction TranscationList : BookTransactionsList){
            if((TranscationList.getRollNo() == rollNo) && ((TranscationList.getReturnDate() == null))){
                total_books_isshued += 1;
            }
            if(total_books_isshued >= 3){
                return false;
            }
        }

        String issue_date = new SimpleDateFormat("dd-mm-yyyy").format(new Date());
       
        BookTransaction book_Transaction = new BookTransaction(isbn,rollNo,issue_date,null);
        BookTransactionsList.add(book_Transaction);
        return true;
    }

    public boolean returnBook(int rollNo , int isbn){
        for(BookTransaction TranscationList : BookTransactionsList){
            if((TranscationList.getRollNo() == rollNo) && (TranscationList.getReturnDate() == null) && (TranscationList.getIsbn() == isbn) ){
                String return_date = new SimpleDateFormat("dd-mm-yyyy").format(new Date());
               TranscationList.setIssueDate(return_date);
               Book obj = new Book();
               obj.setQuentity(obj.getQuentity() + 1);
               return true;
            }
        }
        return false;
    }
    public void ShowAllTranscation(){
        for(BookTransaction bookTransaction : TranscationList){
            System.out.println(bookTransaction);
        }
    }
    public void writetoFile(){
        try {
            oos_Transaction = new ObjectOutputStream(new FileOutputStream(TransactionFile));
            oos_Transaction.writeObject(BookTransactionsList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
