package com.girardsimon.kata.model;

import java.util.LinkedList;
import java.util.Objects;

public class Statement {

    LinkedList<StatementLine> statementLines = new LinkedList<>();

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
}
