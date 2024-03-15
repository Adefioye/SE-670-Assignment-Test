package com.junit.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalcTest {
    @Test
    public void whenAdd_returnResult() {

        assertThat(Calc.add(2, 3)).isEqualTo(5);
    }

    @Test
    public void whenSubtract_returnResult() {

        assertThat(Calc.subtract(5, 2)).isEqualTo(3);
    }

    @Test
    public void whenMultiply_returnResult() {

        assertThat(Calc.multiply(5, 2)).isEqualTo(10);
    }

    @Test
    public void whenDivide_returnResult() {

        assertThat(Calc.divide(10, 2)).isEqualTo(5);
    }

    @Test
    public void whenDivideByZero_returnIllegalArgumentException() {

        assertThatThrownBy(() -> Calc.divide(2, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Cannot divide by zero");
    }
}
