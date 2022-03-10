package com.girardsimon.kata.model;

public record Amount(int value) {

    public static Amount of(int value) {
        return new Amount(value);
    }

    public Amount plus(Amount otherAmount) {
        return of(this.value + otherAmount.value);
    }

    public boolean isGreaterThan(Amount otherAmount) {
        return this.value > otherAmount.value;
    }

    public Amount negative() {
        return of(-value);
    }

    public Amount absoluteValue() {
        return of(Math.abs(value));
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
