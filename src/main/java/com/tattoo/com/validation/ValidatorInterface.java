package com.tattoo.com.validation;

public interface ValidatorInterface<T> {

    void validate(T t);

    void checkPositiveId(Long id);

}
