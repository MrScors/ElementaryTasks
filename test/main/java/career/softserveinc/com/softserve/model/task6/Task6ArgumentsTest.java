package main.java.career.softserveinc.com.softserve.model.task6;

import main.java.career.softserveinc.com.softserve.model.task3.Task3Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Task6ArgumentsTest {
    private static final String PARAM_1 = "resources/testingSugar.txt 6 0,0,0,0,0,0 9,9,9,9,9,9 true"; // all fine
    private static final String PARAM_2 = "resources/testingSugar.txt 6 -1,0,0,0,0,0 9,9,9,9,9,9 false"; // negative value in 1st ticket
    private static final String PARAM_3 = "resources/testingSugar.txt 6 0,0,0,0,0,0 9,-7,9,9,9,9 false"; // negative value in 2nd ticket
    private static final String PARAM_4 = "invalidFilePath.bin 6 0,0,0,0,0,0 9,9,9,9,9,9 false";  // invalid filepath
    private static final String PARAM_5 = "resources/testingSugar.txt 7 0,0,0,0,0,0,0 9,9,9,9,9,9,9 false"; // invalid count of numbers in tickets
    private static final String PARAM_6 = "resources/testingSugar.txt 6 0,0,0,0,0,0,0 9,9,9,9,9,9 false"; // mismatching count of numbers in tickets
    @ParameterizedTest
    @ValueSource(strings = {PARAM_1, PARAM_2, PARAM_3, PARAM_4, PARAM_5, PARAM_6})
    void validateParametrizedTest(String string) {
        String[] splintedArgs = string.split(", ");
        String[] splintedActualArgs = new String[splintedArgs.length-1];
        System.arraycopy(splintedArgs, 0, splintedActualArgs, 0, splintedActualArgs.length);
        Task6Arguments args = new Task6Arguments(splintedActualArgs);
        boolean actual = args.validate();
        boolean expected = Boolean.parseBoolean(splintedArgs[splintedArgs.length-1]);
        assertEquals(expected, actual);
    }
}