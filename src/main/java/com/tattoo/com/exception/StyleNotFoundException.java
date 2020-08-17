package com.tattoo.com.exception;

public class StyleNotFoundException extends RuntimeException {
    public StyleNotFoundException(Long id) {
        super(String.format("Style with id = [%s] not found", id));
    }
}
