package com.girardsimon.kata.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;

import static com.girardsimon.kata.model.StatementType.DEPOSIT;
import static com.girardsimon.kata.model.StatementType.WITHDRAW;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Mock
    private Statement statement;

    private Account account;

    @BeforeEach
    void setUp() {
        account = new Account(statement);
        account.deposit(Amount.of(500), LocalDate.of(2022, 1, 1));
    }

    @Test
    void deposit_should_update_statement_on_bank_account() {
        //When
        account.deposit(Amount.of(1000), LocalDate.of(2022, 2, 2));

        //Then
        StatementLine expectedStatementLine = new StatementLine(DEPOSIT, Amount.of(1000), Amount.of(1500), LocalDate.of(2022, 2, 2));
        verify(statement).addStatementLine(expectedStatementLine);
    }

    @Test
    void withdraw_should_update_statement_on_bank_account() {
        //When
        account.withdraw(Amount.of(400), LocalDate.of(2022, 2, 15));

        //Then
        StatementLine expectedStatementLine = new StatementLine(WITHDRAW, Amount.of(-400), Amount.of(100), LocalDate.of(2022, 2, 15));
        verify(statement).addStatementLine(expectedStatementLine);
    }

    @Test
    void should_print_statement() {
        //When
        System.setOut(new PrintStream(outContent));
        account.deposit(Amount.of(1000), LocalDate.of(2022, 2, 2));
        account.withdraw(Amount.of(400), LocalDate.of(2022, 2, 15));
        account.printStatement();

        //Then
        assertThat(outContent.toString()).contains("DEPOSIT - 01-01-2022 - 500 - 500");
        assertThat(outContent.toString()).contains("DEPOSIT - 01-01-2022 - 1000 - 1500");
        assertThat(outContent.toString()).contains("WITHDRAW - 01-01-2022 - 400 - 1100");
    }
}
