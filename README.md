Library Management System

Overview
This Library Management System is a CLI-based project developed in Java. It is designed to help librarians manage the library efficiently by providing features to handle books and student records. The system allows students to view, issue, and return books, ensuring an organized and streamlined library experience.

Features
Librarian Features
Add a Student: Librarians can add new students to the system.
Delete a Student: Librarians can remove students from the system.
Add a Book: Librarians can add new books to the library inventory.
Delete a Book: Librarians can remove books from the library inventory.
Update Student Record: Librarians can update details of existing students.
Update Book Record: Librarians can update details of existing books.
View All Books: Librarians can see a list of all books available in the library.
Student Features
View All Books: Students can see a list of all books available in the library.
Issue a Book: Students can issue a book using their roll number.
Return a Book: Students can return a book using their roll number.
Data Persistence
File Storage: All data related to books and students is stored in files.
Data Retrieval: Data is retrieved from files when the program starts, ensuring that all information is up-to-date.
Getting Started
Prerequisites
Java Development Kit (JDK) installed
Basic knowledge of Java programming
Installation
Clone the repository:
bash
Copy code
git clone https://github.com/yourusername/library-management-system.git
Navigate to the project directory:
bash
Copy code
cd library-management-system
Compile the Java files:
bash
Copy code
javac *.java
Run the application:
bash
Copy code
java Main
Usage
Librarian Login: Enter the system as a librarian to manage books and student records.
Student Login: Enter the system as a student to view, issue, or return books.
Follow the on-screen instructions to navigate through the system.
Project Structure
css
Copy code
library-management-system/
│
├── src/
│   ├── Main.java
│   ├── Librarian.java
│   ├── Student.java
│   ├── Book.java
│   └── FileManager.java
│
├── data/
│   ├── students.txt
│   ├── books.txt
│
└── README.md
Contributing
Contributions are welcome! Please fork this repository and submit a pull request for any improvements or bug fixes.

Acknowledgments
A big thank you to LearnVern and Rupal Shah for providing such an incredible platform and valuable content, which made this project possible.
