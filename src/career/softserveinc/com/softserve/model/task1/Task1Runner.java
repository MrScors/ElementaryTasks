package career.softserveinc.com.softserve.model.task1;

import career.softserveinc.com.softserve.model.RunnableTasks;
import career.softserveinc.com.softserve.view.Reader;
import career.softserveinc.com.softserve.view.ConsolePrinter;

import java.io.BufferedReader;
import java.io.IOException;

public class Task1Runner implements RunnableTasks {
    private String[] args;

    public Task1Runner(String[] args) {
        this.args = args;
    }

    @Override
    public void run(BufferedReader br) throws IOException {

        Task1Arguments validArguments;
        ConsolePrinter.tellYouAboutTask1();
        ConsolePrinter.askWhetherPassReceivedArguments();
        boolean useArgs = Reader.readYesOrNo(br);
        if (useArgs && new Task1Arguments(args).validate()) {
            validArguments = new Task1Arguments(args);
            ConsolePrinter.writeResultsOfTask(invokeTask1(validArguments));
        } else {
            if (useArgs) {
                ConsolePrinter.writeInvalidArgsErrorMessage();
            }
            do {
                ConsolePrinter.askToWriteSomeArgumentsForTask1();
                validArguments = new Task1Arguments(readConsoleArguments(br));
            } while (!validArguments.validate());
            ConsolePrinter.writeResultsOfTask(invokeTask1(validArguments));
        }
    }

    private static int[] readConsoleArguments(BufferedReader br) {
        int[] consoleArguments;
        do {
            try {
                consoleArguments = Reader.readTask1Arguments(br);
                break;
            } catch (NumberFormatException | IOException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        return consoleArguments;
    }

    private static StringBuilder invokeTask1(ITask1Arguments arguments) {
        int[] argsAsArray = arguments.getArgs();
        ChessBoard chessBoard = new ChessBoard(argsAsArray[0], argsAsArray[1]);
        return new StringBuilder(chessBoard.createBoard());
    }
}
