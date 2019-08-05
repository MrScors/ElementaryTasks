package main.java.career.softserveinc.com.softserve.model.task2;

import main.java.career.softserveinc.com.softserve.model.task3.Task3Arguments;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class EnvelopeTest {

    @ParameterizedTest
    @ValueSource(strings = {"5.6, 2.2, 2.1, 4.3, 1",
            "4.3, 2.1, 5.6, 2.2, -1",
            "5.6, 2.2, 2.2, 5.6, 0",
            "5.6, 2.1, 4.3, 2.2, 0"})
    void compareToParametrizedTestReturnValue(String string) {
        String[] splintedArgs = string.split(", ");
        double[] splintedActualArgs = new double[splintedArgs.length-1];
        for (int i = 0; i < splintedActualArgs.length; i++) {
            splintedActualArgs[i] = Double.parseDouble(splintedArgs[i]);
        }
        Envelope e1 = new Envelope(splintedActualArgs[0], splintedActualArgs[1]);
        Envelope e2 = new Envelope(splintedActualArgs[2], splintedActualArgs[3]);
        int actual = e1.compareTo(e2);
        int expected = Integer.parseInt(splintedArgs[splintedArgs.length-1]);
        assertEquals(expected, actual);
    }
}