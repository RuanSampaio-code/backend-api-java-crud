package br.com.crudspring.exception;

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(Long id ) {
        super("Resgistro nao encontrado com o id: " + id);
    }
}
