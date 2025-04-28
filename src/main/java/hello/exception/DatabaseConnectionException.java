package hello.exception;

import java.io.Serializable;

public class DatabaseConnectionException extends Exception implements Serializable {
    public DatabaseConnectionException(String message) {
        super(message);
    }
}