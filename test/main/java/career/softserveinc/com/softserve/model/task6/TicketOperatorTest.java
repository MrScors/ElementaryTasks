package main.java.career.softserveinc.com.softserve.model.task6;

import main.java.career.softserveinc.com.softserve.model.task3.Task3Arguments;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TicketOperatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"Moscow, 0,0,0,0,0,0 9,9,9,9,9,9",
            "Piter, 0,0,0,0,0,0 9,9,9,9,9,9",
            "Dnipro, 0,0,0,0,0,0 9,9,9,9,9,9",
            "Moscow, 0,0,0,0,0,0 9,9,9,9,9,9",
            "Piter, 0,0,0,0,0,0 9,9,9,9,9,9",
            "Dnipro, 0,0,0,0,0,0 9,9,9,9,9,9"})
    void countNumberOfLuckyTicketsAccordingToInstructionsParametrizedTest(String string) {
        String[] splintedArgs = string.split(", ");
        String[] splintedActualArgs = new String[splintedArgs.length-1];
        String instructions;
        Ticket start;
        Ticket end;
        System.arraycopy(splintedArgs, 0, splintedActualArgs, 0, splintedActualArgs.length);
        boolean actual = TicketOperator.countNumberOfLuckyTicketsAccordingToInstructions();
        boolean expected = Boolean.parseBoolean(splintedArgs[splintedArgs.length-1]);
        assertEquals(expected, actual);
    }
}