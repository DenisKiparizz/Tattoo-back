package com.tattoo.com.entity.order;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum EStatus {
    ACTIVE("Active"),
    CLOSED("Closed"),
    UNDEFINED("Undefined");

    private final String status;
    private static final Map<String, EStatus> statuses = new HashMap<>();

    static {
        Stream.of(values()).forEach(eStatus
                -> statuses.put(eStatus.getStatus().toUpperCase(), eStatus));
    }

    @JsonCreator
    public static EStatus find(String status) {
        return statuses.getOrDefault(status.toUpperCase(), UNDEFINED);
    }
}
