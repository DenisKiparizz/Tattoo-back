package com.tattoo.com.exception;

public class ReviewNotFoundException extends RuntimeException {
    public ReviewNotFoundException(Long id) {
        super(String.format("Review with id = [%s] not found", id));
    }
}
