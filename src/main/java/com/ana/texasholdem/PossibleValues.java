package com.ana.texasholdem;

/**
 * @author Ana on 8/22/2020
 */
public enum PossibleValues implements Comparable<PossibleValues>{

    ROYAL_FLUSH(100),
    STRAIGHT_FLUSH(90),
    FOUR_OF_A_KIND(80),
    FULL_HOUSE(70),
    FLUSH(60),
    STRAIGHT(50),
    THREE_OF_A_KIND(40),
    TWO_PAIRS(30),
    PAIR(20),
    HIGHCARD(10);

    private Integer value;

    PossibleValues(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
