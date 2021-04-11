package co.com.sofka.crud.exception;

public class ValidationException extends RuntimeException {

    public ValidationException(String errorMessage) {
        super(errorMessage);
    }
}