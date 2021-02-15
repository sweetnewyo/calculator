package ru.orudzhev.exceptions;

/**
 * Custom unchecked exception
 */
public class InvalidStringException extends RuntimeException {

    public InvalidStringException(String errorMessage) {
        super(errorMessage);
    }
}
