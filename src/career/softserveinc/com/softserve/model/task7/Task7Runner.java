package career.softserveinc.com.softserve.model.task7;

import career.softserveinc.com.softserve.model.RunnableTasks;
import career.softserveinc.com.softserve.view.ConsolePrinter;
import career.softserveinc.com.softserve.view.Reader;

import java.io.BufferedReader;
import java.io.IOException;

public class Task7Runner implements RunnableTasks {

    private String[] args;

    public Task7Runner(String[] args) {
        this.args = args;
    }

    @Override
    public void run(BufferedReader br) throws IOException {
        Task7Arguments validArguments;
        ConsolePrinter.tellYouAboutTask7();
        ConsolePrinter.askWhetherPassReceivedArguments();
        boolean useArgs = Reader.readYesOrNo(br);
        if (useArgs && new Task7Arguments(args).validate()) {
            validArguments = new Task7Arguments(args);
            ConsolePrinter.writeResultsOfTask(invokeTask7(validArguments));
        } else {
            if (useArgs) {
                ConsolePrinter.writeInvalidArgsErrorMessage();
            }
            validArguments = readValidConsoleArguments(br);
            ConsolePrinter.writeResultsOfTask(invokeTask7(validArguments));
        }
    }

    private static StringBuilder invokeTask7(ITask7Arguments arguments) {
        StringBuilder sb = new StringBuilder();
        sb.append(IntegerSequenceCreator.createSequenceOfIntegersWhichSquareIsLowerThan(arguments.getArgs()));
        return sb;
    }

    private static Task7Arguments readValidConsoleArguments(BufferedReader br) throws IOException {
        Task7Arguments validArguments;
        do {
            ConsolePrinter.askToWriteSomeArgumentsForTask7();
            validArguments = new Task7Arguments(Reader.readTask7Arguments(br));
            if (!validArguments.validate()) {
                ConsolePrinter.writeInvalidArgsErrorMessage();
            } else break;
        } while (true);
        return validArguments;
    }

}
