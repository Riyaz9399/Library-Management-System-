package MAIN_pack;

import java.util.Scanner;
import pkg_Book.Book;
import pkg_Book.BookManager;
import pkg_Exception.BookNotFoundException;
import pkg_Exception.StudentNotFoundException;
import pkg_Transaction.BookTransactionManager;
import pkg_person.Student;
import pkg_person.StudentManager;


public class MAIN  {
    public static void main(String args[])throws ClassNotFoundException{
        int choice;
        Scanner sc = new Scanner(System.in);
       
        StudentManager studentManager = new StudentManager();
        BookManager bookManager = new BookManager();
        BookTransactionManager bookTransactionManager = new BookTransactionManager();

        
        do{
            System.out.println(" Enter 1 for Student \nEnter 2 for Liberian \nEnter 3 for Exit ");
            choice = sc.nextInt();
                // If Student 
            if(choice == 1){
                System.out.println("Enter your Roll Number");
                int rollNo = sc.nextInt();
                try{
                    Student s = studentManager.getRollNo(rollNo);
                    if(s == null){
                        throw new StudentNotFoundException();
                    }
                    int student_choice;
                    do{
                       System.out.println("Enter  1 To view All the books \n Enter 2 Serach book by isbn \n Enter 3 List book By subject \n  Enter 4 for Issue a book \n Enter 5 for return a book \n Enter 99 to EXIT");
                       student_choice = sc.nextInt();
                       sc.nextLine();
                        switch (student_choice) {
                            case 1:
                                System.out.println("All the Book Records are");
                                 bookManager.viewAllBook();
                                break;
                            case 2 :
                                System.out.println("Please Enter ISBN To Search");
                                System.out.println("Enter ISBN of the Book to Search");
                                int search_isbn = sc.nextInt();
                                Book book = bookManager.searchBookBYIsbn(search_isbn);
                                if(book == null){
                                    System.out.println("No book with these Isbn with this ISBN number");
                                }
                                else {
                                    System.out.println(book);
                                }
                              
                                break;
                            case 3 :
                                System.out.println("Enter the name of Subject to Serch a particuler book");
                                String subject = sc.nextLine();
                                bookManager.listBookBySubject(subject);
                                break;
                            case 4 :
                                System.out.println("Enter the ISBN if you want to  Issue a Book"); 
                                int Issue_ISBN = sc.nextInt();
                                Book issue_book = bookManager.searchBookBYIsbn(Issue_ISBN);
                                try{
                                    if(issue_book == null){
                                        throw new BookNotFoundException();
                                    }
                                   if(issue_book.getQuentity() > 0){
                                        if(bookTransactionManager.issueBook(rollNo,Issue_ISBN)){
                                            issue_book.setQuentity(issue_book.getQuentity() - 1);
                                            System.out.println("Book has Been Issue");
                                        }else{
                                            System.out.println("The Book has been Isshu");
                                        }
    
                                    }else{
                                        System.out.println("The Book has been Isshu");
                                    }
                                }catch(BookNotFoundException ie){
                                    System.out.println(ie);
                                }
                               
                                break;
                            case 5 :
                                System.out.println("Please enter the isbn to Return of book"); 
                                int return_isbn = sc.nextInt();
                                book = bookManager.searchBookBYIsbn(return_isbn);
                                if(book != null){
                                    if(bookTransactionManager.returnBook(rollNo, return_isbn))  {
                                        Book reTURN = new Book();
                                        reTURN.setQuentity(reTURN.getQuentity() + 1);
                                        System.out.println("thanks for Returning a book");
                                    } else{
                                        System.out.println("Could not return the book");
                                    }
                                }else{
                                    System.out.println("book With This ISBN does not exists ");
                                }
                                break;    
                            default:
                                 System.out.println("-----Thanks for using liberary------");
                                 break;
                         }
                    }while(student_choice != 99);   
                }catch(StudentNotFoundException ie){
                System.out.println(ie);
                }
            }

            // If liberain 
            else if(choice == 2){
                int Lib_choice ;
                do{  
                    System.out.println(" Enter 11 to view all Students \n Enter 12 To print a student by Roll Number \n Enter 13 To add/ Reguister a Student \n Enter a 14 to update a Student \n Enter a 15 to Delete a student  ");
                    System.out.println(" Enter 21 to view All Books \n ENter 22 to Print  Books Bu isbn \n Enter 23 To Add a new Book \n ENter 24 To update a book \n Enter 25 to Delete a book  ");
                    System.out.println(" Enter 31 To view All Transcations ");
                    System.out.println(" Enter 99 To exit  ");
                    Lib_choice = sc.nextInt();
                    sc.nextLine();
                    switch(Lib_choice){
                        case 11 : // views all student 
                            System.out.println("All the students Records");
                            studentManager.viewAllStudent();
                            break;
                        case 12 :// search a student based on roll number
                            System.out.println("Enter you roll Number to Fetch records");
                            int get_Rollno = sc.nextInt();
                            Student student = studentManager.getRollNo(get_Rollno);
                            if(student == null){
                                System.out.println("No record Matches with this roll number  ");
                            }else{
                                System.out.println(student);
                            }
                            break; 
                        case 13:// adding a student 
                            System.out.println("Enter Student details to Add");    
                            int rollNo ;
                            int std ;
                            String devision ;
                            String name ;
                            String email ; 
                            String phoneNumberStr ;
                            String address ;
                            String DOB ;
                            
                            System.out.println("enter you Roll NUmber ");
                            rollNo = sc.nextInt();
                            System.out.println("Enter Your STD (Standerd as Integer)");
                            std = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter Your Division");
                            devision = sc.nextLine();
                         
                            System.out.println("Enter your Name");
                            name = sc.nextLine();
                            System.out.println("Enter Your email");
                            email = sc.nextLine();
                            System.out.println("Enter Your Phone Number");
                            phoneNumberStr =  sc.nextLine();
                            sc.nextLine();
                            System.out.println("Enter your Address");
                            address = sc.nextLine();
                            
                            System.out.println("Enter yor Date of Birth");
                            DOB = sc.nextLine();
                            Student addStudent = new Student( rollNo , std,  devision,  name ,  email ,  phoneNumberStr ,  address ,  DOB);
                            studentManager.addStudent(addStudent);
                            System.out.println("Student is added");
                            break;
                        case 14 : // Update a student 
                            System.out.println("Enter the roll Number for update a record ");
                            int modifyRollNumber ;
                            modifyRollNumber = sc.nextInt();
                            Student previousrollnumber = studentManager.getRollNo(modifyRollNumber);
                            try{
                            if(previousrollnumber == null)
                                throw new StudentNotFoundException();
                             
                                sc.nextLine();
                                System.out.println("Enter Your STD (Standerd as Integer)");
                                std = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Enter Your Division");
                                devision = sc.nextLine();
                                System.out.println("Enter your Name");
                                name = sc.nextLine();
                                System.out.println("Enter Your email");
                                email = sc.nextLine();
                                System.out.println("Enter Your Phone Number");
                                phoneNumberStr = sc.nextLine();
                                sc.nextLine();
                                System.out.println("Enter your Address");
                                address = sc.nextLine();
                                System.out.println("Enter yor Date of Birth");
                                DOB = sc.nextLine();    
    
                                studentManager.updateStudent(modifyRollNumber, std, devision, name, email, phoneNumberStr, address, DOB);
                                System.out.println("Your Record is updated");
                            }
                            catch(StudentNotFoundException ie){
                                System.out.println(ie);
                                ie.printStackTrace();
                            }
    
                            break;
                        case 15: // to DElete a student 
                            System.out.println("Enter your roll number id you want to delete a record ");
                            int delete_Roll ;
                            delete_Roll = sc.nextInt();
                            if(studentManager.deleteStudent(delete_Roll)){
                                System.out.println("The student is deleted Successfully");
                            }
                            else{
                                System.out.println("No record with given roll number exists");
                            }
                            break;
                        case 21 : // View All books 
                                bookManager.viewAllBook();
                                break;
                        case 22 : // search book by ISBN
                                int search_ISBN ;
                                System.out.println("ENTER the ISBN to Search for book");
                                search_ISBN = sc.nextInt();
                                Book book = bookManager.searchBookBYIsbn(search_ISBN);
                                if(book == null){
                                    System.out.println("No book with these Isbn with this ISBN number");
                                }
                                else {
                                    System.out.println(book);
                                }
                                break;
                        case 23 : // Add a Book 
                            System.out.println("Please enter a book Detail to Add");
                              int Isbn ;
                              String title;
                              String author ;
                              String publisher;
                              int edition;
                              String subject;
                              int Quantity; 
                              System.out.println("Enter your Isbn");
                              Isbn = sc.nextInt();
                              sc.nextLine();
                              System.out.println("Enter your Title ");
                              title = sc.nextLine();
                              System.out.println("Author");
                              author = sc.nextLine();
                              System.out.println("Publisher");
                              publisher = sc.nextLine();
                              System.out.println("Edition");
                              edition = sc.nextInt();
                              System.out.println("Subject");
                              subject = sc.nextLine();
                              sc.nextLine();
                              System.out.println("Quantity");
                              Quantity = sc.nextInt();
                              Book add_book = new Book(Isbn, title, author, publisher, edition, subject, Quantity);
                              bookManager.addBook(add_book);
                              System.out.println("The Book Record is Added");
                              break;
                        case 24 : // Update a Record 
                                System.out.println("Please enter the ISbn to update the existing Book ");
                              int update_isbn  = sc.nextInt(); 
                              try{
                                book = bookManager.searchBookBYIsbn(update_isbn);
                                    if(book == null){
                                    throw new BookNotFoundException();
                                    }else{
                                        System.out.println("Enter your detal to update a book ");
                                         sc.nextLine();
                                         System.out.println("Enter your Title ");
                                         title = sc.nextLine();
                                         System.out.println("Author");
                                         author = sc.nextLine();
                                         System.out.println("Publisher");
                                         publisher = sc.nextLine();
                                         System.out.println("Edition");
                                         edition = sc.nextInt();
                                         sc.nextLine();
                                         System.out.println("Subject");
                                         subject = sc.nextLine();
                                         System.out.println("Quantity");
                                         Quantity = sc.nextInt();
                                         bookManager.updateBook(update_isbn, title, author, publisher, edition, subject, Quantity);
                                    }
                              }catch( BookNotFoundException ie){
                                System.out.println(ie);
                              }
                              break;
                        case 25 :// Delete a Record from the list of book 
                               System.out.println("Please enter the ISbn to Delete  the existing Book ");
                               int delete_isbn  = sc.nextInt(); 
                               try{
                                 book = bookManager.searchBookBYIsbn(delete_isbn);
                                     if(book == null){
                                        throw new BookNotFoundException();
                                     }else {
                                        bookManager.deleteBook(delete_isbn);
                                     }
                                } catch(BookNotFoundException ie){
                                    System.out.println(ie);
                                }
                                System.out.println("Your book has been deleted ");
                                break;
                        case 31:// Show All the transaction 
                                System.out.println("All the transactions are ");
                                bookTransactionManager.ShowAllTranscation();
                                break;            
                        case 99  :                           
                        System.out.println(" ----Thanks for using the liberary----- ");
                            break;    
                        default :
                        System.out.println("Your choice is invalid ");       
                    }  
                }while(Lib_choice != 99);  // inner second loops end  
            }
            
        }while(choice != 3); // first Loop  
        bookManager.writetoFile();
        studentManager.writeTofile();
        bookTransactionManager.writetoFile();
        sc.close();
    }

}

