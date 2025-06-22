package br.com.crudspring.enums;

public enum Category {
    BACKEND("Back-end"), FRONTEND("Front-end");
    
    //variavel para armazenar o valor do enum
    private String value;
    
    //construtor do enum
    private Category(String value) {
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
