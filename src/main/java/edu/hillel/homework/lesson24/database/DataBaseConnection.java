package edu.hillel.homework.lesson24.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection implements AutoCloseable {

    private final String url;
    private final String username;
    private final String password;
    private Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public DataBaseConnection() {
        this.url = "jdbc:mysql://localhost:3306/hillel";
        this.username = "hillel";
        this.password = "hillel";
    }

    public DataBaseConnection(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public Connection getConnection() throws SQLException {
        this.connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
