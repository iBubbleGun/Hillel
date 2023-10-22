package edu.hillel.homework.lesson21.dao;

import edu.hillel.homework.lesson21.dto.Homework;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeworkDao {

    private final Connection connection;

    public HomeworkDao(Connection connection) {
        this.connection = connection;
    }

    public void addHomework(@NotNull Homework homework) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO homework (name, description) VALUES (?, ?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, homework.getName());
            preparedStatement.setString(2, homework.getDescription());
            preparedStatement.executeUpdate();

            try (ResultSet key = preparedStatement.getGeneratedKeys()) {
                if (key.next()) {
                    homework.setId(key.getInt(1));
                } else {
                    throw new SQLException("Failed to return the homework id.");
                }
            }
        }
    }

    public void deleteHomework(int homeworkId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "DELETE FROM homework WHERE id = ?")) {
            preparedStatement.setInt(1, homeworkId);
            preparedStatement.executeUpdate();
        }
    }

    public List<Homework> getAllHomeworks() throws SQLException {
        final List<Homework> homeworks = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM homework")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                final Homework homework = new Homework(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                );
                homeworks.add(homework);
            }
        }
        return homeworks;
    }

    public Homework getHomeworkById(int homeworkId) throws SQLException {
        Homework homework = null;
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT * FROM homework WHERE id = ?")) {
            preparedStatement.setInt(1, homeworkId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                homework = new Homework(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                );
            }
        }
        return homework;
    }
}
