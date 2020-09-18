package com.tattoo.com.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long id) {
        super(String.format("Order with id = [%s] not found", id));
    }
}
