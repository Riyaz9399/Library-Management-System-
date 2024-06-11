package pkg_Book;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;



public class BookManager implements Serializable {
    ObjectOutputStream oos_book = null;
    ObjectInputStream ois_book = null;

    File Book_file = new File("Books.dat");

   private ArrayList<Book> Booklist = null;

    @SuppressWarnings("unchecked")
    public BookManager() throws ClassNotFoundException{
        Booklist = new ArrayList<Book>();
        if(Book_file.exists()){
            try{
                ois_book = new ObjectInputStream(new FileInputStream(Book_file));
                Booklist = (ArrayList <Book>) ois_book.readObject();
                // Object obj = ois_book.readObject();
                // if (obj instanceof ArrayList) {
                //     Booklist = (ArrayList<Book>) obj;
                // }
            }catch(IOException ie){
                ie.printStackTrace();
            }catch(ClassNotFoundException ie){
                ie.printStackTrace();
            }     
        }
    }

    public Book listBookBySubject(String subject){
        for(Book book : Booklist){
            if(book.getSubject().equals(subject)){
                System.out.println(book);
            }
        }
        return null;
    }


    public void addBook(Book book){
        Booklist.add(book);
    }

    public void viewAllBook(){
        for(Book book : Booklist){
            System.out.println(book);
        }
    }

    public Book searchBookBYIsbn(int search_Isbn){
        for(Book book : Booklist){
            if(book.getIsbn() == search_Isbn){
                return book;
            }
        }
        return null;
    }

    public boolean deleteBook(int delete_isbn){
        ListIterator<Book> book_iterator = (ListIterator<Book>) Booklist.listIterator();
        while(book_iterator.hasNext()){
            Book book = book_iterator.next();
            if(book.getIsbn() == delete_isbn){
                Booklist.remove(book);
                return true;
            }
        }
        return false;
    }

    public boolean updateBook(int update_isbn ,String title , String author, String publisher,int edition ,String subject , int Quantity){
        ListIterator<Book> book_iterator = (ListIterator<Book>) Booklist.listIterator();
        while(book_iterator.hasNext()){
            Book book = book_iterator.next();
            if(book.getIsbn() == update_isbn){
                book.setAuthor(author);
                book.setEdition(edition);
                book.setPublisher(publisher);
                book.setQuentity(Quantity);
                book.setSubject(subject);
                book.setTitle(title);
                return true;
            }
        }
        return false;
    }

    public void writetoFile() {
        try {
            oos_book = new ObjectOutputStream(new FileOutputStream(Book_file));
            oos_book.writeObject(Booklist);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos_book != null) {
                    oos_book.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }    

    
}
