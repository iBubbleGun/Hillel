package edu.hillel.homework.lesson34.services;

import edu.hillel.homework.lesson34.DAO.SubjectDAO;
import edu.hillel.homework.lesson34.models.Subject;

import java.util.List;

public class SubjectService {

    private final SubjectDAO subjectDAO = new SubjectDAO();

    public Subject getSubjectById(int id) {
        return subjectDAO.getSubjectById(id);
    }

    public List<Subject> getAllSubjects() {
        return subjectDAO.getAllSubjects();
    }

    public void addSubject(Subject subject) {
        subjectDAO.addSubject(subject);
    }

    public void deleteSubject(int id) {
        subjectDAO.deleteSubject(id);
    }

    public void updateSubject(Subject subject) {
        subjectDAO.updateSubject(subject);
    }
}
