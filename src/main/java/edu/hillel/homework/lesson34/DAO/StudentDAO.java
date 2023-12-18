package edu.hillel.homework.lesson34.DAO;

import edu.hillel.homework.lesson34.models.Student;
import edu.hillel.homework.lesson34.utils.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAO {

    public void addStudent(Student student) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Student attachedStudent = session.merge(student);
            session.persist(attachedStudent);
            transaction.commit();
        }
    }

    public void updateStudent(Student student) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(student);
            transaction.commit();
        }
    }

    public void deleteStudent(int studentId) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            if (student != null) {
                session.remove(student);
            }
            transaction.commit();
        }
    }

    public Student getStudentById(int studentId) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Student student = session.get(Student.class, studentId);
            transaction.commit();
            return student;
        }
    }

    public List<Student> getAllStudents() {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query<Student> query = session.createQuery("FROM Student", Student.class);
            transaction.commit();
            return query.list();
        }
    }
}
