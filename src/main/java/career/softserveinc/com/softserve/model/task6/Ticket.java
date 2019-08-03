package main.java.career.softserveinc.com.softserve.model.task6;

public class Ticket implements Comparable<Ticket>{
    int number=0;
    int[] ticketNumbers;

    Ticket(int[] ticketNumbers) {
        this.ticketNumbers = ticketNumbers;
        for (int i = ticketNumbers.length-1; i > 0 ; i--) {
            number += ticketNumbers[i]*Math.pow(10, i);
        }
    }

    int[] getTicketNumbers(){
        return ticketNumbers;
    }

    int getTicketNumber(){
        return number;
    }

    public int compareTo(Ticket t){
        return Integer.compare(number, t.number);
    }

}
