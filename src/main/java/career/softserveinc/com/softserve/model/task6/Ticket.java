package main.java.career.softserveinc.com.softserve.model.task6;

public class Ticket implements Comparable<Ticket>{
    private int number=0;
    private int[] ticketNumbers;

    Ticket(int[] ticketNumbers) {
        this.ticketNumbers = ticketNumbers;
        for (int i = 0; i < ticketNumbers.length; i++) {
            number += ticketNumbers[ticketNumbers.length-i-1]*Math.pow(10, i);
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
