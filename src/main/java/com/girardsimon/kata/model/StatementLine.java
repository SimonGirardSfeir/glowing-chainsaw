package com.girardsimon.kata.model;

import java.time.LocalDate;

public record StatementLine(StatementType statementType, Amount value,
                            Amount balanceAfterOperation, LocalDate date) {

}
