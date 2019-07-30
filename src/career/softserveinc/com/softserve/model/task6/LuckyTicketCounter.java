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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LuckyTicketCounter {

    private List<Ticket> luckyTickets = new ArrayList<>();
    private String filePath;
    private Ticket firstBorderTicket = new Ticket(new int[]{0,0,0,0,0,0});
    private Ticket lastBorderTicket = new Ticket(new int[]{9,9,9,9,9,9});

    LuckyTicketCounter(String filePath) {
        this.filePath = filePath;
    }

    int countNumberOfLuckyTickets() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String firstLine = br.readLine();
        if (firstLine.equals("Moscow")) return countNumberOfMoscowLuckyTickets();
        else if (firstLine.equals("Piter")) return countNumberOfPetersburgLuckyTickets();
        else if (firstLine.equals("Dnipro")) return countNumberOfDniproLuckyTickets();
        else return countNumberOfAnyLuckyTickets();
    }

    private int countNumberOfMoscowLuckyTickets(){
        Ticket ticket = lastBorderTicket;
        while(!ticket.nextTicket().equals(firstBorderTicket)){
            if(LuckyTicketValidator.isMoscowLucky(ticket.getTicketNumbers())) luckyTickets.add(ticket);
            ticket = ticket.nextTicket();
        }
        return luckyTickets.size();
    }

    private int countNumberOfPetersburgLuckyTickets(){
        Ticket ticket = lastBorderTicket;
        while(!ticket.nextTicket().equals(firstBorderTicket)){
            if(LuckyTicketValidator.isPetersburgLucky(ticket.getTicketNumbers())) luckyTickets.add(ticket);
            ticket = ticket.nextTicket();
        }
        return luckyTickets.size();
    }

    private int countNumberOfDniproLuckyTickets(){
        Ticket ticket = firstBorderTicket;
        while(ticket.lowerThan(lastBorderTicket)){
            if(LuckyTicketValidator.isDniproLucky(ticket.getTicketNumbers())) luckyTickets.add(ticket);
            ticket = ticket.nextTicket();
        }
        return luckyTickets.size();
    }

    private int countNumberOfAnyLuckyTickets(){
        Ticket ticket = firstBorderTicket;
        while(!ticket.nextTicket().equals(lastBorderTicket)){
            if(LuckyTicketValidator.isLucky(ticket.getTicketNumbers())) luckyTickets.add(ticket);
            ticket = ticket.nextTicket();
        }
        return luckyTickets.size();
    }


    StringBuilder getLuckyTickets() {
        StringBuilder sb = new StringBuilder();
        for (Ticket ticket : luckyTickets) {
            sb.append(ticket.toString()).append("\n");
        }
        return sb;
    }
}
