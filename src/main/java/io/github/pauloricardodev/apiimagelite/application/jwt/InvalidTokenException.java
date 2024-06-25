package io.github.pauloricardodev.apiimagelite.application.jwt;

public class InvalidTokenException extends RuntimeException{

    public InvalidTokenException(String message) {
        super(message);
    }
}
