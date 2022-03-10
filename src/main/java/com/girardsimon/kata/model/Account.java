package com.girardsimon.kata.model;

import java.time.LocalDate;

import static com.girardsimon.kata.model.StatementType.DEPOSIT;
import static com.girardsimon.kata.model.StatementType.WITHDRAW;

public class Account {

    private Amount balance;

    private final Statement statement;

    public Account(Amount initialAmount) {
        this.balance = initialAmount;
        this.statement = new Statement();
    }

    public void deposit(Amount amount, LocalDate date) {
        this.balance = balance.plus(amount);
        statement.addStatementLine(new StatementLine(DEPOSIT, amount, balance, date));
    }

    public void withdraw(Amount amount, LocalDate date) {
        this.balance = balance.plus(amount.negative());
        statement.addStatementLine(new StatementLine(WITHDRAW, amount, balance, date));
    }

    public Statement getStatement() {
        return statement;
    }
}
