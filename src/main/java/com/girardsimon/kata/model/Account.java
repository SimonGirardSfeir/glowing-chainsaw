package com.girardsimon.kata.model;

import static com.girardsimon.kata.model.StatementType.DEPOSIT;
import static com.girardsimon.kata.model.StatementType.WITHDRAW;

public class Account {

    private Amount balance;

    private final Statement statement;

    public Account(Amount initialAmount) {
        this.balance = initialAmount;
        this.statement = new Statement();
    }

    public void deposit(Amount amount) {
        this.balance = balance.plus(amount);
        statement.addStatementLine(new StatementLine(DEPOSIT, amount, balance));
    }

    public void withdraw(Amount amount) {
        this.balance = balance.plus(amount.negative());
        statement.addStatementLine(new StatementLine(WITHDRAW, amount, balance));
    }

    public Amount getBalance() {
        return balance;
    }

    public Statement getStatement() {
        return statement;
    }
}
