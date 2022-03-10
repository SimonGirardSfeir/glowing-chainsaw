package com.girardsimon.kata.model;

import java.util.ArrayList;
import java.util.List;

public class Statement {

    private final List<StatementLine> statementLines = new ArrayList<>();

    public void addStatementLine(StatementLine statementLine) {
        statementLines.add(statementLine);
    }

    @Override
    public String toString() {
        return statementLines.toString();
    }
}
