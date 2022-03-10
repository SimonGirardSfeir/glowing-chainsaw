package com.girardsimon.kata.model;

public record StatementLine(StatementType statementType, Amount value,
                            Amount balanceAfterOperation) {

}
