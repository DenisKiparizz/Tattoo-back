package com.tattoo.com.exception;

public class IncorrectStyleException extends IllegalAccessError {
    public IncorrectStyleException(String style) {
        super(String.format("Style [%s] does not exist", style));
    }
}
