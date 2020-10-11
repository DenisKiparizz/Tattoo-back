package com.tattoo.com.exception;

import com.tattoo.com.entity.order.EPartOfBody;

public class PartOfBodyNotFoundException extends RuntimeException {
    public PartOfBodyNotFoundException(Long id) {
        super(String.format("Part of body with id = [%s] not found", id));
    }

    public PartOfBodyNotFoundException(EPartOfBody part) {
        super(String.format("Part of body with name  = [%s] not found", part));
    }
}
