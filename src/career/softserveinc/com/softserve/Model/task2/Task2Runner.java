package career.softserveinc.com.softserve.Model.task2;

import career.softserveinc.com.softserve.Model.RunnableTasks;
import career.softserveinc.com.softserve.View.Reader;
import career.softserveinc.com.softserve.View.Writer;

import java.io.BufferedReader;
import java.io.IOException;

public class Task2Runner implements RunnableTasks {

    private String[] args;

    public Task2Runner(String[] args) {
        this.args = args;
    }

    @Override
    public void run(BufferedReader br) {
        double[] consoleArguments;
        Task2Arguments validArguments;
        Writer.tellYouAboutTask2();
        Writer.askWhetherPassReceivedArguments();
        boolean yesOrNo;

        do {
            try {
                yesOrNo = Reader.readYesOrNo(br);
                break;
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        if (yesOrNo && new Task2Arguments(args).validate()) {
            validArguments = new Task2Arguments(args);
            boolean doAgain;
            do {
                Writer.writeResultsOfTask(invokeTask2(validArguments));
                do {
                    try {
                        doAgain = Reader.readYesOrNo(br);
                        break;
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
                if (doAgain) {
                    do {
                        Writer.askToWriteSomeArgumentsForTask2();
                        do {
                            try {
                                consoleArguments = Reader.readTask2Arguments(br);
                                break;
                            } catch (NumberFormatException | IOException e) {
                                System.out.println(e.getMessage());
                            }
                        } while (true);
                        validArguments = new Task2Arguments(consoleArguments);
                    } while (!validArguments.validate());
                } else {
                    break;
                }
            } while (true);
        } else {
            if (yesOrNo) {
                Writer.writeInvalidArgsErrorMessage();
            }
            boolean doAgain;
            do {
                do {
                    Writer.askToWriteSomeArgumentsForTask2();
                    do {
                        try {
                            consoleArguments = Reader.readTask2Arguments(br);
                            break;
                        } catch (NumberFormatException | IOException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (true);
                    validArguments = new Task2Arguments(consoleArguments);
                    if (!validArguments.validate()) {
                        Writer.writeInvalidArgsErrorMessage();
                    } else break;
                } while (true);
                Writer.writeResultsOfTask(invokeTask2(validArguments));
                Writer.askWhetherDoOnceMore();
                do {
                    try {
                        doAgain = Reader.readYesOrNo(br);
                        break;
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                } while (true);
            } while (doAgain);

        }
    }

    static StringBuilder invokeTask2(ITask2Arguments arguments) {
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
