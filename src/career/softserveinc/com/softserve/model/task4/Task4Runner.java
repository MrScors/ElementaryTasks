package career.softserveinc.com.softserve.model.task4;

import career.softserveinc.com.softserve.model.RunnableTasks;
import career.softserveinc.com.softserve.view.ConsolePrinter;
import career.softserveinc.com.softserve.view.Reader;

import java.io.BufferedReader;
import java.io.IOException;

public class Task4Runner implements RunnableTasks {

    private String[] args;

    public Task4Runner(String[] args) {
        this.args = args;
    }

    @Override
    public void run(BufferedReader br) throws IOException {
        Task4Arguments validArguments;
        ConsolePrinter.tellYouAboutTask4();
        ConsolePrinter.askWhetherPassReceivedArguments();
        boolean useArgs = Reader.readYesOrNo(br);
        if (useArgs && new Task4Arguments(args).validate(br)) {
            validArguments = new Task4Arguments(args);
            ConsolePrinter.writeResultsOfTask(invokeTask4(validArguments));
        } else {
            if (useArgs) {
                ConsolePrinter.writeInvalidArgsErrorMessage();
            }
            validArguments = readValidConsoleArguments(br);
            ConsolePrinter.writeResultsOfTask(invokeTask4(validArguments));
        }
    }

    private static StringBuilder invokeTask4(ITask4Arguments arguments) throws IOException {
        StringBuilder sb = new StringBuilder();
        FileManager fm = new FileManager(arguments.getArgs()[0]);
        if (arguments.getArgs().length == 2) {
            sb.append("Number of given strings: ");
            sb.append(fm.countNumberOfSubstrings(arguments.getArgs()[1]));
        } else {
            sb.append("Resulting file's content:\n");
            fm.changeSubstringsToAnother(arguments.getArgs()[1], arguments.getArgs()[2]);
            sb.append(fm.readFile());
        }
        return sb;
    }

    private static Task4Arguments readValidConsoleArguments(BufferedReader br) {
        Task4Arguments validArguments;
        do {
            ConsolePrinter.askToWriteSomeArgumentsForTask4();
            validArguments = new Task4Arguments(readConsoleArguments(br));
            if (!validArguments.validate(br)) {
                ConsolePrinter.writeInvalidArgsErrorMessage();
            } else break;
        } while (true);
        return validArguments;
    }

    private static String[] readConsoleArguments(BufferedReader br) {
        String consoleArguments;
        do {
            try {
                consoleArguments = Reader.readTask4Arguments(br);
                break;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return consoleArguments.split(" ");


    }

}
