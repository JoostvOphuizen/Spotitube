package nl.han.dea.joost.datasource.connection;

import jakarta.inject.Inject;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionService {

    private Connection connection;
    private DatabaseProperties databaseProperties;

    @Inject
    public void setDatabaseProperties(DatabaseProperties databaseProperties) {
        this.databaseProperties = databaseProperties;
    }

    public void initializeConnection() {
        try {
            connection = DriverManager.getConnection(databaseProperties.getConnectionString());
        } catch (Exception e) {
            // todo: handle: database connection exception
            throw new RuntimeException("Database connection error");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
