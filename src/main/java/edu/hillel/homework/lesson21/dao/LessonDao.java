package edu.hillel.homework.lesson21.dao;

import edu.hillel.homework.lesson21.dto.Lesson;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LessonDao {

    public void addLesson(@NotNull Lesson lesson) {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "INSERT INTO lesson (name, updatedAt, homework_id) VALUES (?, ?, ?)",
                     PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, lesson.getName());
            preparedStatement.setTimestamp(2, lesson.getUpdatedAt());
            preparedStatement.setInt(3, lesson.getHomework().getId());
            preparedStatement.executeUpdate();

            try (ResultSet key = preparedStatement.getGeneratedKeys()) {
                if (key.next()) {
                    lesson.setId(key.getInt(1));
                } else {
                    throw new SQLException("Failed to return the lesson id.");
                }
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deleteLesson(int lessonId) {
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM lesson WHERE id = ?")) {
            preparedStatement.setInt(1, lessonId);
            preparedStatement.executeUpdate();
            System.out.println("The lesson with id \"" + lessonId + "\" was successfully deleted."); // debug
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Lesson> getAllLessons() {
        final List<Lesson> lessons = new ArrayList<>();
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM lesson")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                final Lesson lesson = new Lesson(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getTimestamp("updatedAt"),
                        new HomeworkDao().getHomeworkById(resultSet.getInt("homework_id"))
                );
                lessons.add(lesson);
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return lessons;
    }

    public Lesson getLessonById(int lessonId) {
        Lesson lesson = null;
        try (Connection connection = DataBaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM lesson WHERE id = ?")) {
            preparedStatement.setInt(1, lessonId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                lesson = new Lesson(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getTimestamp("updatedAt"),
                        new HomeworkDao().getHomeworkById(resultSet.getInt("homework_id"))
                );
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return lesson;
    }
}
