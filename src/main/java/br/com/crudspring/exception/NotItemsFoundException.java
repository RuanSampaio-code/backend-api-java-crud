package br.com.crudspring.exception;

public class NotItemsFoundException extends RuntimeException {
    public NotItemsFoundException(String message) {
        super(message);
    }
}
