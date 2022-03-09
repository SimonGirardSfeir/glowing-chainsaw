package com.girardsimon.kata.model;

import org.junit.jupiter.api.Test;

import static com.girardsimon.kata.model.Amount.of;
import static org.assertj.core.api.Assertions.assertThat;

class AmountTest {

    @Test
    void amount_should_be_equal_to_other_amount_when_value_is_the_same() {
        //Given...When...Then
        assertThat(new Amount(1000)).isEqualTo(new Amount(1000));
    }

    @Test
    void amount_should_be_not_equal_to_other_amount_when_values_are_different() {
        //Given...When...Then
        assertThat(new Amount(1000)).isNotEqualTo(new Amount(200));
    }

    @Test
    void of_should_statically_initialize_an_amount() {
        //Given
        Amount givenAmount = new Amount(1000);

        //When
        Amount actualAmount = of(1000);

        //Then
        assertThat(actualAmount).isEqualTo(givenAmount);
    }

    @Test
    void plus_should_add_amount() {
        //Given
        Amount givenAmount1 = new Amount(400);
        Amount givenAmount2 = new Amount(600);

        //When
        Amount actualAmount = givenAmount1.plus(givenAmount2);

        //Then
        Amount expectedAmount = new Amount(1000);
        assertThat(actualAmount).isEqualTo(expectedAmount);
    }
}
