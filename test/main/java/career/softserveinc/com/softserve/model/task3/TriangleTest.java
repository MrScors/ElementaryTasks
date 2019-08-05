package main.java.career.softserveinc.com.softserve.model.task3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTest {

    @ParameterizedTest
    @ValueSource(strings = {"1, 1, 1, 0.43",
            "2, 2, 2, 1.73",
            "6, 2, 5, 4.68",
            "9, 8, 9, 32.24",
            "22, 12, 12, 52.75",
            "5, 7, 5, 12.49",
            "3, 2, 3, 2.82"})
    void getSquareParametrizedTest(String string) {
        String[] splintedArgs = string.split(", ");
        int[] sides = new int[splintedArgs.length - 1];
        double expected = Double.parseDouble(splintedArgs[splintedArgs.length - 1]);
        for (int i = 0; i < splintedArgs.length - 1; i++) {
            sides[i] = Integer.parseInt(splintedArgs[i]);
        }
        assertEquals(expected, (Math.floor(new Triangle("name", sides[0], sides[1], sides[2]).getSquare())));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 1, 1, [name]: 0.43 cm",
            "2, 2, 2, [name]: 1.73 cm",
            "6, 2, 5, [name]: 4.68 cm",
            "9, 8, 9, [name]: 32.24 cm",
            "22, 12, 12, [name]: 52.75 cm",
            "5, 7, 5, [name]: 12.49 cm",
            "3, 2, 3, [name]: 2.82 cm"})
    void toStringParametrizedTest(String string) {
        String[] splintedArgs = string.split(", ");
        int[] sides = new int[splintedArgs.length - 1];
        String expected = splintedArgs[splintedArgs.length - 1];
        for (int i = 0; i < splintedArgs.length - 1; i++) {
            sides[i] = Integer.parseInt(splintedArgs[i]);
        }
        assertEquals(expected, new Triangle("name", sides[0], sides[1], sides[2]).toString());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 1, 1, 2, 2, 2, -1",
            "2, 2, 2, 2, 2, 2, 0",
            "6, 2, 5, 5, 2, 6, 0",
            "9, 8, 9, 8, 8, 9, 1",
            "22, 12, 12, 12, 11, 11, -1",
            "5, 7, 5, 2, 2, 2, 1",
            "3, 2, 3, 7, 7, 7, -1"})
    void compareToParametrizedTest(String string) {
        String[] splintedArgs = string.split(", ");
        int[] sides = new int[splintedArgs.length - 1];
        int expected = Integer.parseInt(splintedArgs[splintedArgs.length - 1]);
        for (int i = 0; i < splintedArgs.length - 1; i++) {
            sides[i] = Integer.parseInt(splintedArgs[i]);
        }
        assertEquals(expected, new Triangle("name", sides[0], sides[1], sides[2]).compareTo(new Triangle("name", sides[3], sides[4], sides[5])));
    }

}