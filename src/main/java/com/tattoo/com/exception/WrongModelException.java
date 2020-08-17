package com.tattoo.com.exception;

public class WrongModelException extends IllegalAccessError {
    public WrongModelException(String error) {
        super(String.format("Field consider some mistake: %s ", error));
    }}
