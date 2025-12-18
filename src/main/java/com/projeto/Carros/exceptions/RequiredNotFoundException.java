package com.projeto.Carros.exceptions;

public class RequiredNotFoundException extends RuntimeException {
    public RequiredNotFoundException(String message) {
        super(message);
    }
}
