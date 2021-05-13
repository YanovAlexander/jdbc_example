package ua.goit.jdbc.config;

import org.postgresql.ds.PGConnectionPoolDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseConnectionManager {
    PGConnectionPoolDataSource pgConnectionPoolDataSource = new PGConnectionPoolDataSource();

    public DatabaseConnectionManager(String host, String databaseName, String username, String password) {
        initDataSource(host, databaseName, username, password);
    }

    public Connection getConnection() {
        try {
            return pgConnectionPoolDataSource.getConnection();
        } catch (SQLException throwables) {
            System.err.println(throwables.getMessage());
            throw new RuntimeException(throwables);
        }
    }

    private void initDataSource(String host, String databaseName, String username, String password) {
        pgConnectionPoolDataSource.setUrl(String.format("jdbc:postgresql://%s/%s", host, databaseName));
        pgConnectionPoolDataSource.setUser(username);
        pgConnectionPoolDataSource.setPassword(password);
    }
}
