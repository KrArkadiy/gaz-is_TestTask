package ru.gaz_is.javaapi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseProperties {

    private final String HOST = "jdbc:postgresql://localhost:5432/javaapi";
    private final String USERNAME = "postgres";
    private final String PASSWORD = "arkadiy";
    private Connection connection;

    public DataBaseProperties() throws SQLException{
        this.connection = DriverManager.getConnection(HOST,USERNAME,PASSWORD);
    }

    public Connection getConnection() {
        return connection;
    }
}
