package career.softserveinc.com.softserve.model.task2;

import career.softserveinc.com.softserve.model.RunnableTasks;
import career.softserveinc.com.softserve.view.Reader;
import career.softserveinc.com.softserve.view.ConsolePrinter;

import java.io.BufferedReader;
import java.io.IOException;

public class Task2Runner implements RunnableTasks {

    private String[] args;

    public Task2Runner(String[] args) {
        this.args = args;
    }

    @Override
    public void run(BufferedReader br) throws IOException {
        Task2Arguments validArguments;
        ConsolePrinter.tellYouAboutTask2();
        ConsolePrinter.askWhetherPassReceivedArguments();
        boolean useArgs = Reader.readYesOrNo(br);
        if (useArgs && new Task2Arguments(args).validate()) {
            validArguments = new Task2Arguments(args);
        } else {
            if(useArgs) ConsolePrinter.writeInvalidArgsErrorMessage();
            validArguments = readValidConsoleArguments(br);
        }

        ConsolePrinter.writeResultsOfTask(invokeTask2(validArguments));

        ConsolePrinter.askWhetherDoOnceMore();
        while (Reader.readYesOrNo(br)) {
            validArguments = readValidConsoleArguments(br);
            ConsolePrinter.writeResultsOfTask(invokeTask2(validArguments));
        }

    }

    private static Task2Arguments readValidConsoleArguments(BufferedReader br) {
        Task2Arguments validArguments;
        do {
            ConsolePrinter.askToWriteSomeArgumentsForTask2();
            validArguments = new Task2Arguments(readConsoleArguments(br));
            if (!validArguments.validate()) {
                ConsolePrinter.writeInvalidArgsErrorMessage();
            } else break;
        } while (true);
        return validArguments;
    }

    private static double[] readConsoleArguments(BufferedReader br) {
        double[] consoleArguments;
        do {
            try {
                consoleArguments = Reader.readTask2Arguments(br);
                break;
            } catch (NumberFormatException | IOException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return consoleArguments;
    }

    private static StringBuilder invokeTask2(ITask2Arguments arguments) {
        double[] argsAsArray = arguments.getArgs();
        Envelope e1 = new Envelope(argsAsArray[0], argsAsArray[1]);
        Envelope e2 = new Envelope(argsAsArray[2], argsAsArray[3]);
        if (e1.compareTo(e2) > 0) {
            return new StringBuilder("Envelope1 can be accommodated in Envelope2");
        } else if (e2.compareTo(e1) > 0) {
            return new StringBuilder("Envelope2 can be accommodated in Envelope1");
        } else {
            return new StringBuilder("This two envelopes do not fit each other");
        }
    }


}
