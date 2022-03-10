package com.girardsimon.kata.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

import static com.girardsimon.kata.model.StatementType.DEPOSIT;
import static com.girardsimon.kata.model.StatementType.WITHDRAWAL;

public class Account {

    private static final Logger log = LoggerFactory.getLogger(Account.class);

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
        String statementToPrint = statement.toString();
        log.info(statementToPrint);
    }
}
