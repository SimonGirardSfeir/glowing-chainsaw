package com.girardsimon.kata.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Statement {

    private final List<StatementLine> statementLines = new ArrayList<>();

    public void addStatementLine(StatementLine statementLine) {
        statementLines.add(statementLine);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return Objects.equals(statementLines, statement.statementLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statementLines);
    }

    @Override
    public String toString() {
        return statementLines.toString();
    }
}
