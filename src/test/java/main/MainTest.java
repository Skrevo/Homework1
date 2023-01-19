package main;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

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
        int expectedNumberOfSteps = 241;
        assertThat(Main.countNumberOfSteps()).isCloseTo(expectedNumberOfSteps, Percentage.withPercentage(0.1));
    }

    @Test
    void testIndexOfMaxY() {
        int expectedIndex = Arrays.stream(Main.createArrayOfY()).boxed().toList().indexOf(6.6570574401545795);
        assertThat(Main.indexOfMaxY()).isCloseTo(expectedIndex, Percentage.withPercentage(0.01));
    }

    @Test
    void testIndexOfMinY() {
        int expectedIndex = Arrays.stream(Main.createArrayOfY()).boxed().toList().indexOf(-8.92688070170253);
        assertThat(Main.indexOfMinY()).isCloseTo(expectedIndex, Percentage.withPercentage(0.01));
    }
}