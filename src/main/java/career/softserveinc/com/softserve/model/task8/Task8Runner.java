package main.java.career.softserveinc.com.softserve.model.task8;

import main.java.career.softserveinc.com.softserve.model.RunnableTasks;
import main.java.career.softserveinc.com.softserve.view.ConsolePrinter;
import main.java.career.softserveinc.com.softserve.arguments_input.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;

public class Task8Runner implements RunnableTasks {

    private String[] args;

    public Task8Runner(String[] args) {
        this.args = args;
    }

    @Override
    public void run(BufferedReader br) throws IOException{
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

    private static StringBuilder invokeTask8(ITask8Arguments arguments){
        StringBuilder sb = new StringBuilder();
        if (arguments.getArgs().length == 2) {
            sb.append("SubSequence between given borders is:\n");
            for (BigInteger bi: FibonacciManager.findSubSequence(arguments.getArgs()[0], arguments.getArgs()[1])) {
                sb.append(bi.toString());
                sb.append("\n");
            }
        } else {
            sb.append("SubSequence of Fibonacci Numbers with given length:\n");
            for (BigInteger bi: FibonacciManager.findSubSequence(arguments.getArgs()[0].intValue())) {
                sb.append(bi.toString());
                sb.append("\n");
            }
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

    private static BigInteger[] readConsoleArguments(BufferedReader br) throws NumberFormatException{
        BigInteger[] consoleArguments;
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
