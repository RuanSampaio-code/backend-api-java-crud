package br.com.crudspring.exception;

public class ResourceAlredyExistsException extends RuntimeException {
    public ResourceAlredyExistsException(String message) {
        super(message);
    }
}
