package main.java.career.softserveinc.com.softserve.model.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1ArgumentsTest {

    // getArgs

    @Test
    void getArgsTestStringArgsGiven() {
        Task1Arguments task1Arguments = new Task1Arguments(new String[]{"5", "7"});
        int[] actual = task1Arguments.getArgs();
        int[] expected = new int[]{5, 7};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getArgsTestNonNumberArgsGiven() {
        Task1Arguments task1Arguments = new Task1Arguments(new String[]{"seven", "21"});
        int[] actual = task1Arguments.getArgs();
        int[] expected = new int[]{-1, -1};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getArgsTestIntArgsGiven() {
        Task1Arguments task1Arguments = new Task1Arguments(new int[]{5, 7});
        int[] actual = task1Arguments.getArgs();
        int[] expected = new int[]{5, 7};
        assertArrayEquals(expected, actual);
    }

    @Test
    void getArgsTestInvalidIntArgsGiven() {
        Task1Arguments task1Arguments = new Task1Arguments(new int[]{-1, 22});
        int[] actual = task1Arguments.getArgs();
        int[] expected = new int[]{-1, 22};
        assertArrayEquals(expected, actual);
    }

    // validate

    @Test
    void validateTestStringArgsGiven() {
        Task1Arguments task1Arguments = new Task1Arguments(new String[]{"5", "7"});
        boolean actual = task1Arguments.validate();
        assertTrue(actual);
    }

    @Test
    void validateTestNonNumberArgsGiven() {
        Task1Arguments task1Arguments = new Task1Arguments(new String[]{"seven", "21"});
        boolean actual = task1Arguments.validate();
        assertFalse(actual);
    }

    @Test
    void validateTestIntArgsGiven() {
        Task1Arguments task1Arguments = new Task1Arguments(new int[]{5, 7});
        boolean actual = task1Arguments.validate();
        assertTrue(actual);
    }

    @Test
    void validateTestInvalidIntArgsGiven() {
        Task1Arguments task1Arguments = new Task1Arguments(new int[]{-1, 22});
        boolean actual = task1Arguments.validate();
        assertFalse(actual);
    }
}