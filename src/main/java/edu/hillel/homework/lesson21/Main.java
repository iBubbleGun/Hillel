package edu.hillel.homework.lesson21;

import edu.hillel.homework.lesson21.dao.DataBaseConnection;
import edu.hillel.homework.lesson21.dao.HomeworkDao;
import edu.hillel.homework.lesson21.dao.LessonDao;
import edu.hillel.homework.lesson21.dto.Homework;
import edu.hillel.homework.lesson21.dto.Lesson;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try (DataBaseConnection dataBaseConnection = new DataBaseConnection();
             Connection connection = dataBaseConnection.getConnection()) {

            HomeworkDao homeworkDao = new HomeworkDao(connection);
            LessonDao lessonDao = new LessonDao(connection);

            final Homework hw_monday = new Homework("Monday #1", "Homework for Monday.");
            final Homework hw_tuesday = new Homework("Tuesday #1", "Homework for Tuesday.");

            homeworkDao.addHomework(hw_monday);
            lessonDao.addLesson(new Lesson("Mathematics", hw_monday));
            lessonDao.addLesson(new Lesson("Physics", hw_monday));
            lessonDao.addLesson(new Lesson("Chemistry", hw_monday));
            lessonDao.addLesson(new Lesson("Astronomy", hw_monday));
            lessonDao.addLesson(new Lesson("History", hw_monday));

            homeworkDao.addHomework(hw_tuesday);
            lessonDao.addLesson(new Lesson("Literature", hw_tuesday));
            lessonDao.addLesson(new Lesson("Geometry", hw_tuesday));
            lessonDao.addLesson(new Lesson("Chemistry", hw_tuesday));
            lessonDao.addLesson(new Lesson("Algebra", hw_tuesday));
            lessonDao.addLesson(new Lesson("English", hw_tuesday));

            System.out.println(lessonDao.getAllLessons());

            // receive lesson with id 15
            int id = 15;
            Lesson lesson = lessonDao.getLessonById(id);
            if (lesson != null) {
                System.out.println("Lesson with id \"" + id + "\": " + lesson);

                lessonDao.deleteLesson(id); // delete lesson with id 15
            } else {
                System.out.println("Lesson with id \"" + id + "\" doesn't found!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
