package main;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @BeforeEach
    void setUp() {
    }

    @ParameterizedTest
    @CsvSource({"1.7, 16.4963", "1.5, 3.9574", "2.0, 1.0755"})
    void testFunction(double x, double expectedY) {
        assertThat(Main.function(x)).isCloseTo(expectedY, Percentage.withPercentage(0.01));
    }

    @Test
    void testCountNumberOfSteps() {
        double borderDown = 0.8;
        double borderUp = 2.0;
        double delta = 0.005;
        int expectedNumberOfSteps = 241;
        assertThat(Main.countNumberOfSteps(borderDown, borderUp, delta)).isCloseTo(expectedNumberOfSteps, Percentage.withPercentage(0.1));
    }
}