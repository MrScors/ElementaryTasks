package career.softserveinc.com.softserve.Model.task1;

import career.softserveinc.com.softserve.Model.RunnableTasks;
import career.softserveinc.com.softserve.View.Reader;
import career.softserveinc.com.softserve.View.Writer;

public class Task1Runner implements RunnableTasks {
    String[] args;

    public Task1Runner(String[] args){
        this.args = args;
    }

    @Override
    public void run() {

        int[] consoleArguments;
        Task1Arguments validArguments;
        Writer.tellYouAboutTask1();
        Writer.askWhetherPassReceivedArguments();
        if (Reader.readYesOrNo() && new Task1Arguments(args).validate()) {
            validArguments = new Task1Arguments(args);
            Writer.writeResultsOfTask(invokeTask1(validArguments));
        } else {
            do {
                Writer.askToWriteSomeArgumentsForTask1();
                consoleArguments = Reader.readTask1Arguments();
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
