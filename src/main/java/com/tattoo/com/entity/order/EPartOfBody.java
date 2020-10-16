package com.tattoo.com.entity.order;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum EPartOfBody {
    FOOT("Foot"),
    LEG("Leg"),
    ARM("Arm"),
    HAND("Hand"),
    STOMACH("Stomach"),
    CHEST("Chest"),
    NECK("Neck"),
    UNDEFINED("Undefined");

    private  final String partOfBody;
    private static final Map<String, EPartOfBody> partOfBodyMap = new HashMap<>();

    static {
        Stream.of(values()).forEach(parts
                -> partOfBodyMap.put(parts.getPartOfBody().toUpperCase(), parts));
    }

    @JsonCreator
    public static EPartOfBody find(String part) {
        return partOfBodyMap.getOrDefault(part.toUpperCase(), UNDEFINED);
    }
}
