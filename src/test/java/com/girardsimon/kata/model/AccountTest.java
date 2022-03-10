package com.girardsimon.kata.model;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

import static com.girardsimon.kata.model.StatementType.DEPOSIT;
import static com.girardsimon.kata.model.StatementType.WITHDRAWAL;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AccountTest {

    private ListAppender<ILoggingEvent> logWatcher;

    @Mock
    private Statement statement;

    private Account account;

    @BeforeEach
    void setUp() {
        logWatcher = new ListAppender<>();
        logWatcher.start();
        ((Logger) LoggerFactory.getLogger(Account.class)).addAppender(logWatcher);
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
        StatementLine expectedStatementLine = new StatementLine(WITHDRAWAL, Amount.of(400), Amount.of(100), LocalDate.of(2022, 2, 15));
        verify(statement).addStatementLine(expectedStatementLine);
    }

    @Test
    void should_print_statement() {
        //Given
        Statement givenStatement = new Statement();
        Account givenAccount = new Account(givenStatement);

        //When
        givenAccount.deposit(Amount.of(1000), LocalDate.of(2022, 2, 2));
        givenAccount.withdraw(Amount.of(400), LocalDate.of(2022, 2, 15));
        givenAccount.printStatement();

        //Then

        assertThat(logWatcher.list.size()).isOne();
        assertThat(logWatcher.list.get(0).getFormattedMessage()).contains("DEPOSIT - 2022-02-02 - 1000 - 1000");
        assertThat(logWatcher.list.get(0).getFormattedMessage()).contains("WITHDRAWAL - 2022-02-15 - 400 - 600");
        assertThat(logWatcher.list.get(0).getLevel()).isEqualTo(Level.INFO);
    }
}
