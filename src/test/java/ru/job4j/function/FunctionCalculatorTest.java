package ru.job4j.function;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCalculatorTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenX2FunctionThenX2Results() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(2, 5, x -> x * x);
        List<Double> expected = Arrays.asList(4D, 9D, 16D);
        assertThat(result).containsAll(expected);
    }

    @Test
    public void whenPowFunctionThenPowResults() {
        FunctionCalculator function = new FunctionCalculator();
        List<Double> result = function.diapason(2, 5, x -> Math.pow(x, 3));
        List<Double> expected = Arrays.asList(8D, 27D, 64D);
        assertThat(result).containsAll(expected);
    }
}