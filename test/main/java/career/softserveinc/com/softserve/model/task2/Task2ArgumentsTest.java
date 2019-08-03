package main.java.career.softserveinc.com.softserve.model.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task2ArgumentsTest {

    @Test
    void getArgsTestStringArgsGiven() {
        Task2Arguments task2Arguments = new Task2Arguments(new String[]{"5.6", "2.2", "4.3", "2.1"});
        double[] actual = task2Arguments.getArgs();
        double[] expected = new double[]{5.6, 2.2, 4.3, 2.1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getArgsTestNonNumberArgsGiven() {
        Task2Arguments task2Arguments = new Task2Arguments(new String[]{"seven", "potato", "2", "2.1"});
        double[] actual = task2Arguments.getArgs();
        double[] expected = new double[]{-1, -1, -1, -1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getArgsTestIntArgsGiven() {
        Task2Arguments task2Arguments = new Task2Arguments(new double[]{5.6, 2.2, 4.3, 2.1});
        double[] actual = task2Arguments.getArgs();
        double[] expected = new double[]{5.6, 2.2, 4.3, 2.1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getArgsTestInvalidIntArgsGiven() {
        Task2Arguments task2Arguments = new Task2Arguments(new double[]{-5.6, -2.2, 4.3, -2.1});
        double[] actual = task2Arguments.getArgs();
        double[] expected = new double[]{-5.6, -2.2, 4.3, -2.1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void validateTestStringArgsGiven() {
        Task2Arguments task2Arguments = new Task2Arguments(new String[]{"5.6", "2.2", "4.3", "2.1"});
        boolean actual = task2Arguments.validate();
        assertTrue(actual);
    }

    @Test
    void validateTestNonNumberArgsGiven() {
        Task2Arguments task2Arguments = new Task2Arguments(new String[]{"seven", "potato", "2", "2.1"});
        boolean actual = task2Arguments.validate();
        assertFalse(actual);
    }

    @Test
    void validateTestIntArgsGiven() {
        Task2Arguments task2Arguments = new Task2Arguments(new double[]{5.6, 2.2, 4.3, 2.1});
        boolean actual = task2Arguments.validate();
        assertTrue(actual);
    }

    @Test
    void validateTestInvalidIntArgsGiven() {
        Task2Arguments task2Arguments = new Task2Arguments(new double[]{-5.6, -2.2, 4.3, -2.1});
        boolean actual = task2Arguments.validate();
        assertFalse(actual);
    }
}