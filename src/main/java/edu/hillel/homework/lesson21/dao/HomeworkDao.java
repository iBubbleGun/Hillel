package edu.hillel.homework.lesson21.dao;

import edu.hillel.homework.lesson21.dto.Homework;
import org.jetbrains.annotations.NotNull;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HomeworkDao {

    public void addHomework(@NotNull Homework homework) {
        try (PreparedStatement preparedStatement = DataBaseConnection.getConnection()
                .prepareStatement(
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
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void deleteHomework(int homeworkId) {
        try (PreparedStatement preparedStatement = DataBaseConnection.getConnection()
                .prepareStatement("DELETE FROM homework WHERE id = ?")) {
            preparedStatement.setInt(1, homeworkId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<Homework> getAllHomeworks() {
        final List<Homework> homeworks = new ArrayList<>();
        try (PreparedStatement preparedStatement = DataBaseConnection.getConnection()
                .prepareStatement("SELECT * FROM homework")) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                final Homework homework = new Homework(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                );
                homeworks.add(homework);
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return homeworks;
    }

    public Homework getHomeworkById(int homeworkId) {
        Homework homework = null;
        try (PreparedStatement preparedStatement = DataBaseConnection.getConnection()
                .prepareStatement("SELECT * FROM homework WHERE id = ?")) {
            preparedStatement.setInt(1, homeworkId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                homework = new Homework(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("description")
                );
            }
        } catch (SQLException e) {
            //e.printStackTrace();
            throw new RuntimeException(e);
        }
        return homework;
    }
}
