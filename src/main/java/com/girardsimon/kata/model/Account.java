package com.girardsimon.kata.model;

import java.time.LocalDate;

import static com.girardsimon.kata.model.StatementType.DEPOSIT;
import static com.girardsimon.kata.model.StatementType.WITHDRAW;

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
        addStatement(WITHDRAW, amount.negative(), date);
    }

    private void addStatement(StatementType statementType, Amount amount, LocalDate date) {
        Amount balanceAfterStatementLine = balance.plus(amount);
        statement.addStatementLine(new StatementLine(statementType, amount, balanceAfterStatementLine, date));
        balance = balanceAfterStatementLine;
    }
}
