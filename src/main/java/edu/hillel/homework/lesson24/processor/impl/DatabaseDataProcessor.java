package edu.hillel.homework.lesson24.processor.impl;

import edu.hillel.homework.lesson24.database.DataBaseConnection;
import edu.hillel.homework.lesson24.processor.DataProcessor;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

public class DatabaseDataProcessor implements DataProcessor {

    @Override
    public void processData(@NotNull Map<Integer, String> data) {
        final String sql = "INSERT INTO data_storage (id, info) VALUES (?, ?)";
        try (DataBaseConnection database = new DataBaseConnection();
             Connection connection = database.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            for (Map.Entry<Integer, String> entry : data.entrySet()) {
                preparedStatement.setInt(1, entry.getKey());
                preparedStatement.setString(2, entry.getValue());
                preparedStatement.executeUpdate();
                //System.out.println("Write in to database: " + entry); // debug
            }
            System.out.println("Writing data to mysql database completed successfully.");
        } catch (SQLException err) {
            throw new RuntimeException("An error occurred while writing data in to database.", err);
        }
    }
}
