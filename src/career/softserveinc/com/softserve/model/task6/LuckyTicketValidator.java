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

package career.softserveinc.com.softserve.model.task6;

class LuckyTicketValidator {

    static boolean isValid(int[] ticketNumbers) {
        boolean isValid = true;
        if (ticketNumbers.length % 2 != 0 || ticketNumbers.length < 6) return false;
        for (int ticketNumber : ticketNumbers) {
            if (ticketNumber < 0) {
                isValid = false;
                break;
            }
        }
        return isValid;
    }

    static boolean isLucky(int[] ticketNumbers) {
        return (isMoscowLucky(ticketNumbers) || isPetersburgLucky(ticketNumbers) || isDniproLucky(ticketNumbers));
    }

    static boolean isMoscowLucky(int[] ticketNumbers) {
        int firstHalfValues = 0;
        int secondHalfValues = 0;
        for (int i = 0; i < ticketNumbers.length / 2; i++) {
            firstHalfValues += ticketNumbers[i];
        }
        for (int i = ticketNumbers.length / 2; i < ticketNumbers.length; i++) {
            secondHalfValues += ticketNumbers[i];
        }
        return firstHalfValues == secondHalfValues;
    }

    static boolean isPetersburgLucky(int[] ticketNumbers) {
        int firstHalfValues = 0;
        int secondHalfValues = 0;
        for (int ticketNumber : ticketNumbers) {
            if (ticketNumber % 2 == 0) firstHalfValues += ticketNumber;
            else secondHalfValues += ticketNumber;
        }
        return firstHalfValues == secondHalfValues;
    }

    static boolean isDniproLucky(int[] ticketNumbers) {
        int firstHalfValues = 0;
        int secondHalfValues = 0;
        for (int i = 0; i < ticketNumbers.length; i++) {
            if (i % 2 == 0) firstHalfValues += ticketNumbers[i];
            else secondHalfValues += ticketNumbers[i];
        }
        return firstHalfValues == secondHalfValues;
    }

}
