package main.java.career.softserveinc.com.softserve.model.task6;


class TicketOperator {

    static int countNumberOfLuckyTicketsAccordingToInstructions(String instructions, Ticket start, Ticket end){
        if(instructions.equals("Moscow")) return  countNumberOfMoscowLuckyTicket(start, end);
        if(instructions.equals("Piter")) return  countNumberOfPiterLuckyTicket(start, end);
        if(instructions.equals("Dnipro")) return  countNumberOfDniproLuckyTicket(start, end);
        else return  countNumberOfAllLuckyTickets(start, end);
    }

    private static Ticket getNextTicket(Ticket t) {
        int[] newTicketNumbers = t.getTicketNumbers();
        newTicketNumbers[newTicketNumbers.length - 1]++;
        for (int i = newTicketNumbers.length - 1; i > 0; i--) {
            if (newTicketNumbers[i] == 10) {
                newTicketNumbers[i] = 0;
                newTicketNumbers[i - 1]+=1;
            }
        }
        if (newTicketNumbers[newTicketNumbers.length - 1] == 10) {
            for (int i = 0; i < newTicketNumbers.length; i++) {
                newTicketNumbers[i] = 0;
            }
        }
        return new Ticket(newTicketNumbers);
    }

    private static int countNumberOfAllLuckyTickets(Ticket start,Ticket end){
        Ticket ticket = start;
        int counter = 0;
        do {
            ticket = getNextTicket(ticket);
            if (isMoscowLucky(ticket) || isPiterLucky(ticket) || isDniproLucky(ticket)) counter++;
        } while (!getNextTicket(ticket).equals(end));
        return counter;
    }

    private static int countNumberOfMoscowLuckyTicket(Ticket start, Ticket end) {
        Ticket ticket = start;
        int counter = 0;
        do {
            ticket = getNextTicket(ticket);
            if (isMoscowLucky(ticket)) counter++;
        } while (ticket.compareTo(end) < 0);
        return counter;
    }

    private static int countNumberOfPiterLuckyTicket(Ticket start, Ticket end) {
        Ticket ticket = start;
        int counter = 0;
        do {
            ticket = getNextTicket(ticket);
            if (isPiterLucky(ticket)) counter++;
        } while (ticket.compareTo(end) < 0);
        return counter;
    }

    private static int countNumberOfDniproLuckyTicket(Ticket start, Ticket end) {
        Ticket ticket = start;
        int counter = 0;
        do {
            ticket = getNextTicket(ticket);
            if (isDniproLucky(ticket)) counter++;
        } while (!getNextTicket(ticket).equals(end));
        return counter;
    }
    private static boolean isMoscowLucky(Ticket t) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < t.getTicketNumbers().length; i++) {
            if (i < t.getTicketNumbers().length/2) sum1 += t.getTicketNumbers()[i];
            else sum2 += t.getTicketNumbers()[i];
        }
        return sum1 == sum2;
    }

    private static boolean isPiterLucky(Ticket t) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < t.getTicketNumbers().length; i++) {
            if (i % 2 == 0) sum1 += t.getTicketNumbers()[i];
            else sum2 += t.getTicketNumbers()[i];
        }
        return sum1 == sum2;
    }

    private static boolean isDniproLucky(Ticket t) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < t.getTicketNumbers().length; i++) {
            if (t.getTicketNumbers()[i] % 2 == 0) sum1 += t.getTicketNumbers()[i];
            else sum2 += t.getTicketNumbers()[i];
        }
        return sum1 == sum2;
    }

}
