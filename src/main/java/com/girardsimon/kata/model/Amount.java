package com.girardsimon.kata.model;

public class Amount {

    public Amount(int value) {
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Amount;
    }
}
