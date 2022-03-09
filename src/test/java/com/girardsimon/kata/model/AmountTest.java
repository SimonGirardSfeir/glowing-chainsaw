package com.girardsimon.kata.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AmountTest {

    @Test
    void amount_should_be_equal_to_other_amount_when_value_is_the_same() {
        //Given...When...Then
        assertThat(new Amount(1000)).isEqualTo(new Amount(1000));
    }
}
