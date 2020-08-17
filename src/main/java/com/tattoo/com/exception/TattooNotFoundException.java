package com.tattoo.com.exception;

public class TattooNotFoundException extends RuntimeException {
    public TattooNotFoundException(Long id) {
        super(String.format("Picture with id = [%s] not found", id));
    }
}
