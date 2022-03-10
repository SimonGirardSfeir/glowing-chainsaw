package com.girardsimon.kata.model;

import java.time.LocalDate;
import java.util.StringJoiner;

public record StatementLine(StatementType statementType, Amount value,
                            Amount balanceAfterOperation, LocalDate date) {

    private static final String DELIMITER = " - ";
    @Override
    public String toString() {
        return new StringJoiner(DELIMITER)
                .add(statementType.toString())
                .add(date.toString())
                .add(value.toString())
                .add(balanceAfterOperation.toString())
                .toString();
    }
}
