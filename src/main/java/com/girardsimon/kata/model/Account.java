package com.girardsimon.kata.model;

public class Account {

    private Amount balance;

    public Account(int value) {
        this.balance = Amount.of(value);
    }

    public void deposit(int value) {
        this.balance = balance.plus(Amount.of(value));
    }

    public Amount getBalance() {
        return balance;
    }
}
