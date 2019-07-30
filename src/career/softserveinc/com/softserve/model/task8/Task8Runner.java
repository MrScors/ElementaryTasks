package career.softserveinc.com.softserve.model.task8;

import career.softserveinc.com.softserve.model.RunnableTasks;
import career.softserveinc.com.softserve.model.task4.FileManager;
import career.softserveinc.com.softserve.model.task4.ITask4Arguments;
import career.softserveinc.com.softserve.model.task4.Task4Arguments;
import career.softserveinc.com.softserve.view.ConsolePrinter;
import career.softserveinc.com.softserve.view.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class Task8Runner implements RunnableTasks {

    private String[] args;

    public Task8Runner(String[] args) {
        this.args = args;
    }

    @Override
    public void run(BufferedReader br) throws IOException {
        Task8Arguments validArguments;
        ConsolePrinter.tellYouAboutTask8();
        ConsolePrinter.askWhetherPassReceivedArguments();
        boolean useArgs = Reader.readYesOrNo(br);
        if (useArgs && new Task8Arguments(args).validate()) {
            validArguments = new Task8Arguments(args);
            ConsolePrinter.writeResultsOfTask(invokeTask8(validArguments));
        } else {
            if (useArgs) {
                ConsolePrinter.writeInvalidArgsErrorMessage();
            }
            validArguments = readValidConsoleArguments(br);
            ConsolePrinter.writeResultsOfTask(invokeTask8(validArguments));
        }
    }

    private static StringBuilder invokeTask8(ITask8Arguments arguments) {
        StringBuilder sb = new StringBuilder();
        if (arguments.getArgs().length == 2) {
            sb.append("SubSequence between given borders is: ");
            sb.append(Arrays.toString(FibonacciManager.findSubSequence
                    (arguments.getArgs()[0], arguments.getArgs()[1])));
        } else {
            sb.append("SubSequence with given length: ");
            sb.append(Arrays.toString(FibonacciManager.findSubSequence(arguments.getArgs()[0])));
        }
        return sb;
    }

    private static Task8Arguments readValidConsoleArguments(BufferedReader br) {
        Task8Arguments validArguments;
        do {
            ConsolePrinter.askToWriteSomeArgumentsForTask8();
            validArguments = new Task8Arguments(readConsoleArguments(br));
            if (!validArguments.validate()) {
                ConsolePrinter.writeInvalidArgsErrorMessage();
            } else break;
        } while (true);
        return validArguments;
    }

    private static long[] readConsoleArguments(BufferedReader br) throws NumberFormatException{
        long[] consoleArguments;
        do {
            try {
                consoleArguments = Reader.readTask8Arguments(br);
                break;
            } catch (NumberFormatException | IOException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return consoleArguments;


    }

}
