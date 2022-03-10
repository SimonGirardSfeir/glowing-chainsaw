package com.girardsimon.kata.model;

import java.time.LocalDate;

import static com.girardsimon.kata.model.StatementType.DEPOSIT;
import static com.girardsimon.kata.model.StatementType.WITHDRAWAL;

public class Account {

    private Amount balance = Amount.of(0);

    private final Statement statement;

    public Account(Statement statement) {
        this.statement = statement;
    }

    public void deposit(Amount amount, LocalDate date) {
        addStatement(DEPOSIT, amount, date);
    }

    public void withdraw(Amount amount, LocalDate date) {
        addStatement(WITHDRAWAL, amount.negative(), date);
    }

    private void addStatement(StatementType statementType, Amount amount, LocalDate date) {
        Amount balanceAfterStatementLine = balance.plus(amount);
        statement.addStatementLine(new StatementLine(statementType, amount.absoluteValue(), balanceAfterStatementLine, date));
        balance = balanceAfterStatementLine;
    }

    public void printStatement() {
        System.out.println(statement);
    }
}
