package nl.han.dea.joost.datasource.exceptions;

public class DatabaseConnectionException extends RuntimeException {

    public DatabaseConnectionException() {
        super("Database connection error");
    }
}
