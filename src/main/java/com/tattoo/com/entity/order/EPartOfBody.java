package com.tattoo.com.entity.order;

public enum EPartOfBody {
    FOOT(2.4),
    LEG(1.3),
    ARM(0.4),
    HAND(1.1),
    STOMACH(1.9),
    CHEST(3.2),
    NECK(2.1);

    public final Double value;

    EPartOfBody(Double value) {
        this.value = value;
    }
}
