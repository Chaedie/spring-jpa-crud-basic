package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            // createStudent(studentDAO);
            createMultipleStudents(studentDAO);
            // readStudent(studentDAO);
            // readAllStudent(studentDAO);
            // findByLastName(studentDAO);
            // updateFirstName(studentDAO);
            // deleteStudent(studentDAO);
            // deleteAllStudent(studentDAO);
        };

    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        long deletedRowsNumber = studentDAO.deleteAll();
        System.out.println("deletedRowsNumber = " + deletedRowsNumber);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        long studentId = 3;
        System.out.println("Deleting student id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void upodateFirstName(StudentDAO studentDAO) {
        // find id:1's entity
        Student tempStudent = studentDAO.findById(1l);
        System.out.println(tempStudent);

        // update firstname to chaedie
        tempStudent.setFirstName("Batman");
        studentDAO.update(tempStudent);

        // display student of id:1
        System.out.println(tempStudent);
    }

    private void findByLastName(StudentDAO studentDAO) {
        // find by lastName
        List<Student> studentList = studentDAO.findByLastName("Duck");

        // display the results
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private void readAllStudent(StudentDAO studentDAO) {
        // find all students from DB
        System.out.println("Creating new student object...");
        List<Student> studentList = studentDAO.findAll();

        // display students
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    private void readStudent(StudentDAO studentDAO) {
        // create a student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Daffy", "Duck", "Daffy@asdf.com");

        // save the student
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        long id = tempStudent.getId();
        System.out.println("Student ID: " + id);

        // retrieve student by id
        System.out.println("Retriving thd ID ... ");
        Student student = studentDAO.findById(id);

        // display student
        System.out.println("Read Student : " + student);

    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        // create multiple students
        System.out.println("Creating 3 student object...");
        Student tempStudent1 = new Student("John", "Doe", "john@asdf.com");
        Student tempStudent2 = new Student("Mary", "Public", "mary@asdf.com");
        Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@asdf.com");

        // save the student objects
        System.out.println("Saving the students ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);

        // display id of the saved student
        System.out.println("saved student. Generated id : " + tempStudent1.getId());
        System.out.println("saved student. Generated id : " + tempStudent2.getId());
        System.out.println("saved student. Generated id : " + tempStudent3.getId());
    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Chaedie", "IM", "asdf@asdf.com");
        System.out.println("Before saved student. Generated id : " + tempStudent.getId());

        // save the student object
        System.out.println("save");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("saved student. Generated id : " + tempStudent.getId());
    }


}
