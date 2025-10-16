package br.com.fiap.fintech.exception;

public class EntityNotFoundException extends Exception {
    // Constructors
    public EntityNotFoundException() {

    }

    public EntityNotFoundException(String message) {
        super(message);
    }
}
