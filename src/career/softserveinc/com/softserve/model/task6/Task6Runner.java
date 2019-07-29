package career.softserveinc.com.softserve.model.task6;

import career.softserveinc.com.softserve.model.RunnableTasks;
import career.softserveinc.com.softserve.view.ConsolePrinter;
import career.softserveinc.com.softserve.view.Reader;

import java.io.BufferedReader;
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
        if (useArgs && new Task6Arguments(args[0]).validate(br)) {
            validArguments = new Task6Arguments(args[0]);
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
        LuckyTicketCounter ltc = new LuckyTicketCounter(arguments.getArgs());
        sb.append("Number of lucky tickets in this file: ").append
                (ltc.countNumberOfLuckyTicketsInTextFile()).append
                ("\n");
        sb.append("Lucky tickets:\n").append(ltc.getLuckyTickets());
        return sb;
    }

    private static Task6Arguments readValidConsoleArguments(BufferedReader br) throws IOException {
        Task6Arguments validArguments;
        do {
            ConsolePrinter.askToWriteSomeArgumentsForTask6();
            validArguments = new Task6Arguments(Reader.readTask6Arguments(br));
            if (!validArguments.validate(br)) {
                ConsolePrinter.writeInvalidArgsErrorMessage();
            } else break;
        } while (true);
        return validArguments;
    }


}
