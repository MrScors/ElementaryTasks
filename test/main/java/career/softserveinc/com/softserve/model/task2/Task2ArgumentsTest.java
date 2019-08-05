package main.java.career.softserveinc.com.softserve.model.task2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Task2ArgumentsTest {

    @ParameterizedTest
    @ValueSource(strings = {"5.6, 2.2, 2.1, 4.3, 5.6, 2.2, 2.1, 4.3",
            "seven, potato, 5.6, 2.2, -1, -1, -1, -1",
            "5.6, 2.2, 2, 5.5, 5.6, 2.2, 2, 5.5",
            "-5.6, -2.1, 4.3, -2.2, -5.6, -2.1, 4.3, -2.2"})
    void getArgsParametrizedTestWithStrings(String string) {
        String[] splintedArgs = string.split(", ");
        String[] splintedActualArgs = new String[splintedArgs.length/2];
        System.arraycopy(splintedArgs, 0, splintedActualArgs, 0, splintedActualArgs.length);
        Task2Arguments e = new Task2Arguments(splintedActualArgs);
        double[] actual = e.getArgs();
        double[] expected = new double[splintedArgs.length/2];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = Double.parseDouble(splintedArgs[i+splintedArgs.length/2]);
        }
        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5.6, 2.2, 2.1, 4.3, 5.6, 2.2, 2.1, 4.3",
            "5.6, 2.2, 2, 5.5, 5.6, 2.2, 2, 5.5",
            "5.6, 2.2, -2, 5.5, 5.6, 2.2, -2, 5.5",
            "-5.6, -2.1, 4.3, -2.2, -5.6, -2.1, 4.3, -2.2"})
    void getArgsParametrizedTestWithDoubles(String string) {
        String[] splintedArgs = string.split(", ");
        double[] splintedActualArgs = new double[splintedArgs.length/2];
        for (int i = 0; i < splintedActualArgs.length; i++) {
            splintedActualArgs[i] = Double.parseDouble(splintedArgs[i]);
        }
        Task2Arguments e = new Task2Arguments(splintedActualArgs);
        double[] actual = e.getArgs();
        double[] expected = new double[splintedArgs.length/2];
        for (int i = 0; i < expected.length; i++) {
            expected[i] = Double.parseDouble(splintedArgs[i+splintedArgs.length/2]);
        }
        assertArrayEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5.6, 2.2, 2.1, 4.3, true",
            "seven, potato, 5.6, 2.2, false",
            "5.6, 2.2, 2, 5.5, true",
            "-5.6, -2.1, 4.3, -2.2, false"})
    void validateParametrizedTestWithStrings(String string) {
        String[] splintedArgs = string.split(", ");
        String[] splintedActualArgs = new String[splintedArgs.length-1];
        System.arraycopy(splintedArgs, 0, splintedActualArgs, 0, splintedActualArgs.length);
        Task2Arguments e = new Task2Arguments(splintedActualArgs);
        boolean actual = e.validate();
        boolean expected = Boolean.parseBoolean(splintedArgs[splintedArgs.length-1]);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {"5.6, 2.2, 2.1, 4.3, true",
            "5.6, 2.2, 2, 5.5, true",
            "5.6, 2.2, -2, 5.5, false",
            "-5.6, -2.1, 4.3, -2.2, false"})
    void validateParametrizedTestWithDoubles(String string) {
        String[] splintedArgs = string.split(", ");
        double[] splintedActualArgs = new double[splintedArgs.length-1];
        for (int i = 0; i < splintedActualArgs.length; i++) {
            splintedActualArgs[i] = Double.parseDouble(splintedArgs[i]);
        }
        Task2Arguments e = new Task2Arguments(splintedActualArgs);
        boolean actual = e.validate();
        boolean expected = Boolean.parseBoolean(splintedArgs[splintedArgs.length-1]);
        assertEquals(expected, actual);
    }

}