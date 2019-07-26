package career.softserveinc.com.softserve.Model.task1;

import career.softserveinc.com.softserve.Model.RunnableTasks;
import career.softserveinc.com.softserve.View.Reader;
import career.softserveinc.com.softserve.View.Writer;

import java.io.BufferedReader;
import java.io.IOException;

public class Task1Runner implements RunnableTasks {
    private String[] args;

    public Task1Runner(String[] args) {
        this.args = args;
    }

    @Override
    public void run(BufferedReader br) {

        int[] consoleArguments = null;
        boolean yesOrNo;
        Task1Arguments validArguments;
        Writer.tellYouAboutTask1();
        Writer.askWhetherPassReceivedArguments();
        do {
            try {
                yesOrNo = Reader.readYesOrNo(br);
                break;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        if (yesOrNo && new Task1Arguments(args).validate()) {
            validArguments = new Task1Arguments(args);
            Writer.writeResultsOfTask(invokeTask1(validArguments));
        } else {
            do {
                Writer.askToWriteSomeArgumentsForTask1();
                do {
                    try {
                        consoleArguments = Reader.readTask1Arguments(br);
                    } catch (NumberFormatException | IOException e) {
                        System.out.println(e.getMessage());
                    }
                } while (consoleArguments == null);

                validArguments = new Task1Arguments(consoleArguments);
            } while (!validArguments.validate());
            Writer.writeResultsOfTask(invokeTask1(validArguments));
        }
    }

    private static StringBuilder invokeTask1(ITask1Arguments arguments) {
        int[] argsAsArray = arguments.getArgs();
        ChessBoard chessBoard = new ChessBoard(argsAsArray[0], argsAsArray[1]);
        return new StringBuilder(chessBoard.createBoard());
    }
}
