package main.java.career.softserveinc.com.softserve.model.task4;

import main.java.career.softserveinc.com.softserve.model.RunnableTasks;
import main.java.career.softserveinc.com.softserve.view.ConsolePrinter;
import main.java.career.softserveinc.com.softserve.arguments_input.Reader;

import java.io.BufferedReader;
import java.io.IOException;

public class Task4Runner implements RunnableTasks {

    private String[] args;
    private static final int FILEPATH_INDEX = 0;
    private static final int NEW_STRING_INDEX = 1;
    private static final int OLD_STRING_INDEX = 2;
    private static final int STRING_TO_FIND_INDEX = 1;


    public Task4Runner(String[] args) {
        this.args = args;
    }

    @Override
    public void run(BufferedReader br) throws IOException {
        Task4Arguments validArguments;
        ConsolePrinter.tellYouAboutTask4();
        ConsolePrinter.askWhetherPassReceivedArguments();
        boolean useArgs = Reader.readYesOrNo(br);
        if (useArgs && new Task4Arguments(args).validate()) {
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
        FileManager fm = new FileManager(arguments.getArgs()[FILEPATH_INDEX]);
        if (arguments.getArgs().length == 2) {
            sb.append("Number of given strings: ");
            sb.append(fm.countNumberOfSubstrings(arguments.getArgs()[STRING_TO_FIND_INDEX]));
        } else {
            sb.append("Resulting file's content:\n");
            sb.append(fm.changeSubstringsToAnotherInFile(arguments.getArgs()[NEW_STRING_INDEX], arguments.getArgs()[OLD_STRING_INDEX]));
        }
        return sb;
    }

    private static Task4Arguments readValidConsoleArguments(BufferedReader br) {
        Task4Arguments validArguments;
        do {
            ConsolePrinter.askToChoseOptionForTask4();
            validArguments = new Task4Arguments(readConsoleArguments(br));
            if (!validArguments.validate()) {
                ConsolePrinter.writeInvalidArgsErrorMessage();
            } else break;
        } while (true);
        return validArguments;
    }

    private static String[] readConsoleArguments(BufferedReader br) {
        String[] consoleArguments;
        do {
            try {
                consoleArguments = Reader.readTask4Arguments(br);
                break;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return consoleArguments;
    }

}
