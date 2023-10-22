package edu.hillel.homework.lesson21.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection implements AutoCloseable {

    private static final String URL = "jdbc:mysql://localhost:3306/hillel";
    private static final String USERNAME = "hillel";
    private static final String PASSWORD = "hillel";
    private Connection connection;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public DataBaseConnection() throws SQLException {
        this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); // create default connection
    }

    public Connection getConnection() throws SQLException {
        return connection; // return default connection
    }

    public Connection getConnection(String db_url, String db_username, String db_password) throws SQLException {
        this.connection = DriverManager.getConnection(db_url, db_username, db_password); // create custom connection
        return connection; // return custom connection
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }
}
