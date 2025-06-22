package br.com.crudspring.enums;

public enum Status {
    ATIVO("Ativo"),
    INATIVO("Inativo");

    // Variável para armazenar o valor do enum
    private String value;

    // Construtor do enum
    private Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
