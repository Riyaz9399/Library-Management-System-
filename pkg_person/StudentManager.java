package pkg_person;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.ListIterator;

public class StudentManager implements Serializable{
    ObjectOutputStream oos_student = null;
    ObjectInputStream ois_student  = null;

    File studentFile =  new File("Student.dat");
    
    private ArrayList<Student> studentList = null;

   
    @SuppressWarnings("unchecked")
    public StudentManager()throws ClassNotFoundException{
        
        studentList = new ArrayList<Student>();
        if(studentFile.exists()){
            try {
                ois_student = new ObjectInputStream(new FileInputStream(studentFile));
                studentList = (ArrayList<Student>) ois_student.readObject();
                
            } catch (FileNotFoundException e) { 
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    public Student getRollNo(int rollNo){
        for(Student student : studentList){
            if(student.getRollNo() == rollNo){
                return student;
            }
        }
        return null;
    }


    public void viewAllStudent(){
        for(Student student : studentList){
            System.out.println(student);
        }   
    }

    public boolean deleteStudent(int delete_rollNo){
        ListIterator <Student> studenIterator = (ListIterator<Student>) studentList.listIterator();
        while(studenIterator.hasNext()){
            Student student = studenIterator.next();
            if(student.getRollNo() == delete_rollNo){
                studentList.remove(student);
                return true;
            }
        }
        return false;
       
    }
    public boolean updateStudent(int updateRollno ,int std, String devision, String name , String email , String phoneNumberStr , String address , String DOB ){
        ListIterator <Student> studenIterator = (ListIterator<Student>) studentList.listIterator();
        while(studenIterator.hasNext()){
            Student student = studenIterator.next();
            if(student.getRollNo() == updateRollno){
                student.setAddress(address);
                student.setDOB(DOB);
                student.setDevision(devision);
                student.setEmail(email);
                student.setPhoneNumber(phoneNumberStr);
                student.setName(name);
                student.setRollNo(updateRollno);
                student.setStd(std);
                return true ;
            } 
        }

        return false;
    }

    public void writeTofile(){
        try{
            oos_student = new ObjectOutputStream(new FileOutputStream(studentFile));
            oos_student.writeObject(studentList);
            
        }catch(IOException io){
            io.printStackTrace();
        }
    }


}
