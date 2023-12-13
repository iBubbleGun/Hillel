package edu.hillel.homework.lesson34.DAO;

import edu.hillel.homework.lesson34.models.Subject;
import edu.hillel.homework.lesson34.utils.HibernateSession;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class SubjectDAO {

    public void addSubject(Subject subject) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Subject attachedSubject = session.merge(subject);
            session.persist(attachedSubject);
            transaction.commit();
        }
    }

    public void updateSubject(Subject subject) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(subject);
            transaction.commit();
        }
    }

    public void deleteSubject(int subjectId) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Subject subject = session.get(Subject.class, subjectId);
            if (subject != null) {
                session.remove(subject);
            }
            transaction.commit();
        }
    }

    public Subject getSubjectById(int subjectId) {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            return session.get(Subject.class, subjectId);
        }
    }

    public List<Subject> getAllSubjects() {
        try (Session session = HibernateSession.getSessionFactory().openSession()) {
            Query<Subject> query = session.createQuery("FROM Subject", Subject.class);
            return query.list();
        }
    }
}
