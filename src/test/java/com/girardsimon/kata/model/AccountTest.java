package com.girardsimon.kata.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AccountTest {

    @Test
    void deposit_should_add_credit_on_bank_account() {
        //Given
        Account givenAccount = new Account(500);

        //When
        givenAccount.deposit(1000);

        //Then
        assertThat(givenAccount.getBalance()).isEqualTo(Amount.of(1500));
    }
}
