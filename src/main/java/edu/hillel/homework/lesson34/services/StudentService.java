package edu.hillel.homework.lesson34.services;

import edu.hillel.homework.lesson34.DAO.StudentDAO;
import edu.hillel.homework.lesson34.models.Student;

import java.util.List;

public class StudentService {

    private final StudentDAO studentDAO = new StudentDAO();

    public Student getStudentById(int id) {
        return studentDAO.getStudentById(id);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public void deleteStudent(int id) {
        studentDAO.deleteStudent(id);
    }

    public void updateStudent(Student student) {
        studentDAO.updateStudent(student);
    }
}
