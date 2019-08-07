package main.java.career.softserveinc.com.softserve.model.task6;

import main.java.career.softserveinc.com.softserve.model.RunnableTasks;
import main.java.career.softserveinc.com.softserve.view.ConsolePrinter;
import main.java.career.softserveinc.com.softserve.arguments_input.Reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Task6Runner implements RunnableTasks {

    private String[] args;

    public Task6Runner(String[] args) {
        this.args = args;
    }

    @Override
    public void run(BufferedReader br) throws IOException {
        Task6Arguments validArguments;
        ConsolePrinter.tellYouAboutTask6();
        ConsolePrinter.askWhetherPassReceivedArguments();
        boolean useArgs = Reader.readYesOrNo(br);
        if (useArgs && new Task6Arguments(args).validate()) {
            validArguments = new Task6Arguments(args);
            ConsolePrinter.writeResultsOfTask(invokeTask6(validArguments));
        } else {
            if (useArgs) {
                ConsolePrinter.writeInvalidArgsErrorMessage();
            }
            validArguments = readValidConsoleArguments(br);
            ConsolePrinter.writeResultsOfTask(invokeTask6(validArguments));
        }
    }

    private static StringBuilder invokeTask6(ITask6Arguments arguments) throws IOException {
        StringBuilder sb = new StringBuilder();
        Ticket start = new Ticket(arguments.getStartTicketNumbers());
        Ticket end = new Ticket(arguments.getEndTicketNumbers());
        String instructions = readWayToCountTickets(arguments.getFilePath());
        sb.append(TicketOperator.countNumberOfLuckyTicketsAccordingToInstructions(instructions, start, end));
        return sb;
    }

    private static Task6Arguments readValidConsoleArguments(BufferedReader br) throws IOException {
        Task6Arguments validArguments;
        do {
            ConsolePrinter.askToWriteSomeArgumentsForTask6();
            validArguments = new Task6Arguments(Reader.readTask6Arguments(br));
            if (!validArguments.validate()) {
                ConsolePrinter.writeInvalidArgsErrorMessage();
            } else break;
        } while (true);
        return validArguments;
    }

    private static String readWayToCountTickets(String filePath) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(filePath));
        return fileReader.readLine();
    }

}
