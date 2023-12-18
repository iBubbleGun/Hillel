package edu.hillel.homework.lesson34;

import edu.hillel.homework.lesson34.models.Student;
import edu.hillel.homework.lesson34.models.Subject;
import edu.hillel.homework.lesson34.services.StudentService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        final StudentService studentService = new StudentService();

        Subject subject1 = new Subject("Mathematics");
        Subject subject2 = new Subject("Physics");
        Subject subject3 = new Subject("IT");
        Subject subject4 = new Subject("Chemistry");
        Subject subject5 = new Subject("Biology");

        Student student1 = new Student("Tymur", "tymur@gmail.com");
        student1.getSubjects().addAll(List.of(subject1, subject2, subject3, subject4, subject5));

        Student student2 = new Student("Vasya", "vasya@gmail.com");
        student2.getSubjects().addAll(List.of(subject1, subject2, subject5));

        Student student3 = new Student("Olya", "olya@gmail.com");
        student3.getSubjects().addAll(List.of(subject3, subject5));

        Student student4 = new Student("Bob", "bob@gmail.com");
        student4.getSubjects().add(subject2);

        Student student5 = new Student("Maryanna", "maryanna@gmail.com");
        student5.getSubjects().addAll(List.of(subject2, subject4, subject5));

        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.addStudent(student3);
        studentService.addStudent(student4);
        studentService.addStudent(student5);

        System.out.println("All students: " + studentService.getAllStudents());

        studentService.deleteStudent(3);
        System.out.println("All students: " + studentService.getAllStudents());

        student1.setEmail("tymur_hillel@gmail.com");
        studentService.updateStudent(student1);
        System.out.println("All students: " + studentService.getAllStudents());

        System.out.println("Student with id #1: " + studentService.getStudentById(1));
    }
}
