/*
 *          xXx_key-combinations_xXx
 *
 * replace line of code up or down --> ALT + Shift
 * replace block of code up or down --> CTRL + Shift
 *
 * one line comment --> CTRL + /
 * multi-line comment --> CTRL + SHIFT + /
 *
 * copy-paste line or marked scope of code --> CTRL + D
 * delete line --> CTRL + Y
 *
 * make your code look fine --> CTRL + ALT + L
 *
 * surround with some for, if, switch, etc. --> CTRL+ + ALT + T
 * try to solve error / make cod better --> ALT + ENTER
 *
 *              xXx_shortcuts_xXx
 *
 * psvm + TAB <-- main function
 * sout + TAB <-- System.out.println();
 * serr + TAB <-- System.err.println();
 * iter + TAB <-- for (String arg : args)
 * fori + TAB <-- for(int i=0; i< ; i++)
 * I + TAB <-- for (Object o :)
 * see more on CTRL + J
 *
 */

package main.java.career.softserveinc.com.softserve.model.task6;

import java.io.File;
import java.util.Arrays;

public class Task6Arguments implements ITask6Arguments {

    private static final int FILEPATH_INDEX = 0;
    private static final int COUNT_OF_NUMBERS_IN_TICKETS_INDEX = 1;
    private static final int START_TICKET_INDEX = 2;
    private static final int END_TICKET_INDEX = 3;

    private String filePath;
    private int[] startTicketNumbers;
    private int[] endTicketNumbers;
    private int countOfNumbersInTickets;

    Task6Arguments(String stringArgs) {
        this(stringArgs.split(" "));
    }

    Task6Arguments(String[] stringArgs) {
        filePath = stringArgs[FILEPATH_INDEX];

        String[] startTicketNumbersAsStrings = stringArgs[START_TICKET_INDEX].split(",");
        startTicketNumbers = new int[startTicketNumbersAsStrings.length];

        try {
            for (int i = 0; i < startTicketNumbers.length; i++) {
                startTicketNumbers[i] = Integer.parseInt(startTicketNumbersAsStrings[i]);
            }
        } catch (NumberFormatException e) {
            Arrays.fill(startTicketNumbers, -1);
        }

        String[] endTicketNumbersAsStrings = stringArgs[END_TICKET_INDEX].split(",");
        endTicketNumbers = new int[endTicketNumbersAsStrings.length];

        try {
            for (int i = 0; i < startTicketNumbers.length; i++) {
                endTicketNumbers[i] = Integer.parseInt(endTicketNumbersAsStrings[i]);
            }
        } catch (NumberFormatException e) {
            Arrays.fill(endTicketNumbers, -1);
        }
        try {
            countOfNumbersInTickets = Integer.parseInt(stringArgs[COUNT_OF_NUMBERS_IN_TICKETS_INDEX]);
        } catch (NumberFormatException e) {
            countOfNumbersInTickets = -1;
        }
    }

    @Override
    public String getFilePath() {
        return filePath;
    }

    @Override
    public int[] getStartTicketNumbers() {
        return startTicketNumbers;
    }

    @Override
    public int[] getEndTicketNumbers() {
        return endTicketNumbers;
    }

    @Override
    public boolean validate() {
        if (!(new File(filePath).isFile() &&
                countOfNumbersInTickets == startTicketNumbers.length &&
                countOfNumbersInTickets == endTicketNumbers.length)) return false;
        for (int i = 0; i < countOfNumbersInTickets; i++) {
            if (startTicketNumbers[i] < 0) return false;
        }
        for (int i = 0; i < countOfNumbersInTickets; i++) {
            if (endTicketNumbers[i] < 0) return false;
        }
        return true;
    }


}
