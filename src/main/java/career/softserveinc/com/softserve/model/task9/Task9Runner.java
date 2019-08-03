package main.java.career.softserveinc.com.softserve.model.task9;

import main.java.career.softserveinc.com.softserve.model.RunnableTasks;
import main.java.career.softserveinc.com.softserve.view.ConsolePrinter;
import main.java.career.softserveinc.com.softserve.arguments_input.Reader;

import java.io.BufferedReader;
import java.io.IOException;

public class Task9Runner implements RunnableTasks {

    private String[] args;

    public Task9Runner(String[] args) {
        this.args = args;
    }

    @Override
    public void run(BufferedReader br) throws IOException {
        Task9Arguments validArguments;
        ConsolePrinter.tellYouAboutTask9();
        ConsolePrinter.askWhetherPassReceivedArguments();
        boolean useArgs = Reader.readYesOrNo(br);
        if (useArgs && new Task9Arguments(args).validate()) {
            validArguments = new Task9Arguments(args);
            ConsolePrinter.writeResultsOfTask(invokeTask9(validArguments));
        } else {
            if (useArgs) {
                ConsolePrinter.writeInvalidArgsErrorMessage();
            }
            validArguments = readValidConsoleArguments(br);
            ConsolePrinter.writeResultsOfTask(invokeTask9(validArguments));
        }
    }

    private static StringBuilder invokeTask9(ITask9Arguments arguments) {
        StringBuilder sb = new StringBuilder();
        if (arguments.getArgs().length == 3) {
            sb.append("Powered value: ");
            sb.append(EffectiveMath.pow(arguments.getArgs()[0], arguments.getArgs()[1], arguments.getArgs()[2]));
        } else {
            sb.append("Powered value: ");
            sb.append(EffectiveMath.pow(arguments.getArgs()[0], arguments.getArgs()[0], arguments.getArgs()[1]));
        }
        return sb;
    }

    private static Task9Arguments readValidConsoleArguments(BufferedReader br) {
        Task9Arguments validArguments;
        do {
            ConsolePrinter.askToWriteSomeArgumentsForTask9();
            validArguments = new Task9Arguments(readConsoleArguments(br));
            if (!validArguments.validate()) {
                ConsolePrinter.writeInvalidArgsErrorMessage();
            } else break;
        } while (true);
        return validArguments;
    }

    private static int[] readConsoleArguments(BufferedReader br) throws NumberFormatException{
        int[] consoleArguments;
        do {
            try {
                consoleArguments = Reader.readTask9Arguments(br);
                break;
            } catch (NumberFormatException | IOException e) {
                System.err.println(e.getMessage());
            }
        } while (true);
        return consoleArguments;


    }

}
