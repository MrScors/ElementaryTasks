package main.java.career.softserveinc.com.softserve.model.task6;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class TicketOperatorTest {
    private static final int INSTRUCTIONS_INDEX = 0;
    private static final int TICKET_NUMBERS_1_INDEX = 1;
    private static final int TICKET_NUMBERS_2_INDEX = 2;
    private static final int EXPECTED_INDEX = 3;

    private static final String PARAM_1 = "Moscow 0,0,0,0,0,0 9,9,9,9,9,9 55251";
    private static final String PARAM_2 = "Piter 0,0,0,0,0,0 9,9,9,9,9,9 55251";
    private static final String PARAM_3 = "Dnipro 0,0,0,0,0,0 9,9,9,9,9,9 25080";
    private static final String PARAM_4 = "SOMETHING_ELSE 0,0,0,0,0,0 9,9,9,9,9,9 123013";
    private static final String PARAM_5 = "Moscow 0,0,0,0,0,0 0,0,1,0,0,0 0";
    private static final String PARAM_6 = "Moscow 0,0,0,0,0,0,0,0 9,9,9,9,9,9,9,9 4816029";
    private static final String PARAM_7 = "Piter 0,0,0,0,0,0,0,0 9,9,9,9,9,9,9,9 4816029";
    @ParameterizedTest
    @ValueSource(strings = {PARAM_1, PARAM_2, PARAM_3, PARAM_4, PARAM_5, PARAM_6, PARAM_7})

    void countNumberOfSubstringsParametrizedTest(String string) throws IOException {
        String[] splintedParams = string.split(" ");

        String[] ticketNumbers1AsStrings = splintedParams[TICKET_NUMBERS_1_INDEX].split(",");
        int[] ticketNumbers1 = new int[ticketNumbers1AsStrings.length];
        for (int i = 0; i < ticketNumbers1.length; i++) {
            ticketNumbers1[i] = Integer.parseInt(ticketNumbers1AsStrings[i]);
        }

        String[] ticketNumbers2AsStrings = splintedParams[TICKET_NUMBERS_2_INDEX].split(",");
        int[] ticketNumbers2 = new int[splintedParams[TICKET_NUMBERS_2_INDEX].split(",").length];
        for (int i = 0; i < ticketNumbers2.length; i++) {
            ticketNumbers2[i] = Integer.parseInt(ticketNumbers2AsStrings[i]);
        }

        int actual = TicketOperator.countNumberOfLuckyTicketsAccordingToInstructions(splintedParams[INSTRUCTIONS_INDEX],
                new Ticket(ticketNumbers1), new Ticket(ticketNumbers2));
        int expected = Integer.parseInt(splintedParams[EXPECTED_INDEX]);
        assertEquals(expected, actual);
    }
}