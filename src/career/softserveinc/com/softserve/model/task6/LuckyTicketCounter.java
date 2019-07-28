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
import java.util.List;

class LuckyTicketCounter {

    private List<Ticket> luckyTickets = new ArrayList<>();
    private String filePath;

    LuckyTicketCounter(String filePath) {
        this.filePath = filePath;
    }

    int countNumberOfLuckyTicketsInTextFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String firstLine = br.readLine();
        if(firstLine.equals("Moscow")) return countNumberOfMoscowLuckyTickets(br);
        if(firstLine.equals("Piter")) return countNumberOfPetersburgLuckyTickets(br);
        if(firstLine.equals("Dnipro")) return countNumberOfDniproLuckyTickets(br);
        return countNumberOfLuckyTickets(br);
    }

    private int countNumberOfMoscowLuckyTickets(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] splintedLine = line.split(" ");
            for (String pieceOfLine:splintedLine) {
                if(pieceOfLine.length()%2==0 && pieceOfLine.length()>=6){
                    char[] ticketNumbersInChars = pieceOfLine.toCharArray();
                    int[] ticketNumbers = new int[ticketNumbersInChars.length];
                    for (int i=0; i<ticketNumbersInChars.length; i++) {
                        try{
                            ticketNumbers[i] = Character.getNumericValue(ticketNumbersInChars[i]);
                        }catch(NumberFormatException ignored){}
                    }
                    if(LuckyTicketValidator.isMoscowLucky(ticketNumbers)){
                        luckyTickets.add(new Ticket(ticketNumbers));
                    }

                }
            }
        }
        br.close();
        return luckyTickets.size();
    }

    private int countNumberOfPetersburgLuckyTickets(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] splintedLine = line.split(" ");
            for (String pieceOfLine:splintedLine) {
                if(pieceOfLine.length()%2==0 && pieceOfLine.length()>=6){
                    char[] ticketNumbersInChars = pieceOfLine.toCharArray();
                    int[] ticketNumbers = new int[ticketNumbersInChars.length];
                    for (int i=0; i<ticketNumbersInChars.length; i++) {
                        try{
                            ticketNumbers[i] = Character.getNumericValue(ticketNumbersInChars[i]);
                        }catch(NumberFormatException ignored){}
                    }
                    if(LuckyTicketValidator.isPetersburgLucky(ticketNumbers)) luckyTickets.add(new Ticket(ticketNumbers));
                }
            }
        }
        br.close();
        return luckyTickets.size();
    }

    private int countNumberOfDniproLuckyTickets(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] splintedLine = line.split(" ");
            for (String pieceOfLine:splintedLine) {
                if(pieceOfLine.length()%2==0 && pieceOfLine.length()>=6){
                    char[] ticketNumbersInChars = pieceOfLine.toCharArray();
                    int[] ticketNumbers = new int[ticketNumbersInChars.length];
                    for (int i=0; i<ticketNumbersInChars.length; i++) {
                        try{
                            ticketNumbers[i] = Character.getNumericValue(ticketNumbersInChars[i]);
                        }catch(NumberFormatException ignored){}
                    }
                    if(LuckyTicketValidator.isDniproLucky(ticketNumbers)) luckyTickets.add(new Ticket(ticketNumbers));
                }
            }
        }
        br.close();
        return luckyTickets.size();
    }

    private int countNumberOfLuckyTickets(BufferedReader br) throws IOException {
        String line;
        while ((line = br.readLine()) != null) {
            String[] splintedLine = line.split(" ");
            for (String pieceOfLine:splintedLine) {
                if(pieceOfLine.length()%2==0 && pieceOfLine.length()>=6){
                    char[] ticketNumbersInChars = pieceOfLine.toCharArray();
                    int[] ticketNumbers = new int[ticketNumbersInChars.length];
                    for (int i=0; i<ticketNumbersInChars.length; i++) {
                        try{
                            ticketNumbers[i] = Character.getNumericValue(ticketNumbersInChars[i]);
                        }catch(NumberFormatException ignored){}
                    }
                    if(LuckyTicketValidator.isLucky(ticketNumbers)) luckyTickets.add(new Ticket(ticketNumbers));

                }
            }
        }
        br.close();
        return luckyTickets.size();
    }


    StringBuilder getLuckyTickets(){
        StringBuilder sb = new StringBuilder();
        for (Ticket ticket: luckyTickets) {
            sb.append(ticket.toString()).append("\n");
        }
        return sb;
    }
}
