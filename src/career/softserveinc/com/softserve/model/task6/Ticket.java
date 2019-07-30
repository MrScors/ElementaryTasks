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

import java.util.Arrays;

class Ticket{

    private int[] ticketNumbers;
    private int number;

    Ticket(int number){
        this.number = number;
        int ticketNumbersCounter=0;
        while(number>0){
            ticketNumbersCounter++;
            number /= 10;
        }
        ticketNumbers = new int[ticketNumbersCounter+1];
        number = this.number;
        while(number>0){
            ticketNumbers[ticketNumbersCounter--] = number/10;
            number /= 10;
        }
    }

    Ticket(int[] ticketNumbers) {
        this.ticketNumbers = ticketNumbers;
        for (int i = ticketNumbers.length-1; i >= 0; i--) {
            number += ticketNumbers[i]*Math.pow(10, i);
        }
    }

    Ticket nextTicket(){
        int[] newTicketNumbers = ticketNumbers;
        newTicketNumbers[newTicketNumbers.length-1]++;
        for (int i = newTicketNumbers.length-1; i > 0; i--) {
            if(newTicketNumbers[i]==10) {
                newTicketNumbers[i] = 0;
                newTicketNumbers[i-1]++;
            } else break;
        }
        if(newTicketNumbers[newTicketNumbers.length-1]==10){
            for (int i = 0; i < newTicketNumbers.length; i++) {
                newTicketNumbers[i] = 0;
            }
        }
        return new Ticket(newTicketNumbers);
    }

    int[] getTicketNumbers(){
        return ticketNumbers;
    }

    boolean lowerThan(Ticket ticket){
        return number < ticket.number;
    }

    @Override
    public String toString(){
        return Arrays.toString(ticketNumbers);
    }

}
