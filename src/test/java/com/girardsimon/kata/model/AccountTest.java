package com.girardsimon.kata.model;

import org.junit.jupiter.api.Test;

import static com.girardsimon.kata.model.StatementType.DEPOSIT;
import static com.girardsimon.kata.model.StatementType.WITHDRAW;
import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {

    @Test
    void deposit_should_update_statement_on_bank_account() {
        //Given
        Account givenAccount = new Account(Amount.of(500));

        //When
        givenAccount.deposit(Amount.of(1000));

        //Then
        StatementLine expectedStatementLine = new StatementLine(DEPOSIT, Amount.of(1000), Amount.of(1500));
        Statement expectedStatement = new Statement();
        expectedStatement.addStatementLine(expectedStatementLine);
        assertThat(givenAccount.getStatement()).isEqualTo(expectedStatement);
    }

    @Test
    void withdraw_should_update_statement_on_bank_account() {
        //Given
        Account givenAccount = new Account(Amount.of(1500));

        //When
        givenAccount.withdraw(Amount.of(400));

        //Then
        StatementLine expectedStatementLine = new StatementLine(WITHDRAW, Amount.of(400), Amount.of(1100));
        Statement expectedStatement = new Statement();
        expectedStatement.addStatementLine(expectedStatementLine);
        assertThat(givenAccount.getStatement()).isEqualTo(expectedStatement);
    }
}
